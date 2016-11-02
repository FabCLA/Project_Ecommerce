/**
 * 
 * @author CLAIN Fabien
 * Date :27/10/2016
 * 
 */
package fr.adaming.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping(value="/index")
public class ClientController {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propri�t�s (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propri�t�s (champs, attributs)
	 */
	@Autowired
	private ICategorieService catService; 
	
	@Autowired
	private IProduitService produitService;
	
	@Autowired
	private ILigneCommandeService LCService;
	
	@Autowired
	private IPanierService panierService;
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private ICommandeService commandeService;
	
	private Panier panier;
	
//----------------------------------------------------------------------------------------------------------------
//---------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
//----------------------------------------------------------------------------------------------------------------
//---------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(ModelMap model){
		
			return "login";
		
	}
	
	@RequestMapping(value="/addClient", method=RequestMethod.POST)
	public String addClient(@ModelAttribute("client") Client client, ModelMap model){
		//V�rifier si le client exist
		int i =clientService.isExistService(client.getMail(), client.getPassword());
		
		if(i==1){
				//Exception � ajouter
		}else{
			//Ajouter client dans la database
			clientService.addClientService(client);
		}

		
		return "login";
	}
	
	@RequestMapping(value="/modifier", method=RequestMethod.POST)
	public String modifier(@ModelAttribute("client") Client cl, ModelMap model, HttpServletRequest req){
		//Recup�rer la session
		HttpSession session = req.getSession();
		Client client = (Client) session.getAttribute("clientSession");
		
		//modifier ses attributs
		client.setNom(cl.getNom());
		client.setAdresse(cl.getAdresse());
		client.setMail(cl.getMail());
		client.setPassword(cl.getPassword());
		client.setTel(cl.getTel());
		
		clientService.updateClientService(client);
		
		return "c_modifClient";
	}
	
	@RequestMapping(value="/modifClient", method=RequestMethod.GET)
	public String modifClient(ModelMap model, HttpServletRequest req){
		//R�cup�rer la session 
		HttpSession session = req.getSession();
		
		//Ajouter le client de la session dans le model
		model.addAttribute("clientS", session.getAttribute("clientSession"));
		
		return "c_modifClient";
	}
	
	@RequestMapping(value="/findClient", method=RequestMethod.POST)
	public String findClient(@ModelAttribute("client") Client cl, HttpServletRequest req, ModelMap model){
		//V�rifier si le client exist
		int i =clientService.isExistService(cl.getMail(), cl.getPassword());

		if(i==1){
			//R�cup�rer le client 
			Client client = clientService.getClientByIdentifiantService(cl.getMail(), cl.getPassword());
			
			//R�cup�rer ou cr�er un panier
			if(panierService.isExistService()==0){
				panier = new Panier();
				panier.setActive(true);
				panierService.addPanierService(panier);
			}else{
				panier = panierService.getActivePanierService();
			}
			
			//Affecter le panier au client
			client.setPanier(panier);
			
			//Cr�er une session
			HttpSession session = req.getSession(true);
			
			//Placer le client dans la session
			session.setAttribute("clientSession", client);
			
			//R�cup�ration de la liste des cat�gories 
			List<Categorie> listeCat = catService.getAllCategorieService();
			model.addAttribute("cat_liste", listeCat);
			
			//R�cup�ration de la liste des produits
			List<Produit> listeProd = produitService.getAllProduitService();
			model.addAttribute("prod_liste", listeProd);
			
			session.setAttribute("color", "green");
			model.addAttribute("loginColor", session.getAttribute("color"));
			model.addAttribute("nomClient", ((Client) session.getAttribute("clientSession")).getNom());
			
			return "c_accueil";
				
		}else{
			
			//Exception � ajouter mauvais identifiant
			return "login";
		}
		
	}
	
	@RequestMapping(value="/accueil", method=RequestMethod.GET)
	public String accueilClient(ModelMap model, HttpServletRequest req){
		//R�cup�ration ou cr�ation d'un panier
		if(panierService.isExistService()==0){
			panier = new Panier();
			panier.setActive(true);
			panier.setPrixTotal(0);
			panier.setNbArticle(0);
			panierService.addPanierService(panier);
			panier = panierService.getActivePanierService();
		}else{
			panier = panierService.getActivePanierService();
		}
		
		model.addAttribute("panierActif", panier);
		
		//R�cup�ration de la liste des cat�gories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//R�cup�ration de la liste des produits
		List<Produit> listeProd = produitService.getAllProduitService();
		model.addAttribute("prod_liste", listeProd);
		
		
		return "c_accueil";
	}
	
	@RequestMapping(value="/catProduit/{nomCategorie}", method=RequestMethod.GET)
	public String produitByCategorie(@PathVariable("nomCategorie") String nomCat, ModelMap model, HttpServletRequest req){
		
		//R�cup�ration de la liste des cat�gories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//R�cup�ration de la cat�gorie
		Categorie cat = catService.getCategorieByNomService(nomCat);
		
		//r�cup�ration de la liste des produits par leur cat�gorie
		List<Produit> listeProdByCat = produitService.getProduitByCategorieService(cat);
		model.addAttribute("prod_liste", listeProdByCat);
		
		//R�cup�rer la session
		HttpSession session = req.getSession();
		
		session.setAttribute("color", "green");
		model.addAttribute("loginColor", session.getAttribute("color"));
		model.addAttribute("nomClient", ((Client) session.getAttribute("clientSession")).getNom());
		
		return "c_accueil";
	}
	
	@RequestMapping(value="/panier", method=RequestMethod.GET)
	public String panier(ModelMap model, HttpServletRequest req){
		Panier panier = panierService.getActivePanierService();
		
		List<LigneCommande> listeLC = LCService.getLCsByPanierService(panier);
		model.addAttribute("liste", listeLC);
		model.addAttribute("panierActif", panier);
		
		return "c_panier";
	}

	@RequestMapping(value="/addProd/{id_produit}",method=RequestMethod.GET)
	public String addProduitInPanier(@PathVariable("id_produit") long produit_id, ModelMap model, HttpServletRequest req){
		//R�cup�ration du produit par l'ID
		Produit produit = produitService.getProduitByIdService(produit_id);
		
		//R�cup�rer ou cr�er un panier
		if(panierService.isExistService()==0){
			panier = new Panier();
			panier.setActive(true);
			panierService.addPanierService(panier);
		}else{
			panier = panierService.getActivePanierService();
		}
		
		
		//Tester si la ligne de commande pour le produit existe
		if(LCService.getLigneCByProduitService(produit, panier)==null){
			LigneCommande ligneC =new LigneCommande();	
			ligneC.setProduit(produit);
			ligneC.setQuantite(1);
			ligneC.setPrix(produit.getPrix());
			ligneC.setPanier(panier);
			
			LCService.addLigneCService(ligneC);	
			
			//Actualisation des donn�es du panier
			int nbArticle = panier.getNbArticle()+1;
			panier.setNbArticle(nbArticle);
			
			double prixTotal = panier.getPrixTotal()+produit.getPrix();
			panier.setPrixTotal(prixTotal);
			
		}else{
			LigneCommande ligneC =LCService.getLigneCByProduitService(produit, panier);
			
			//Tester si la quantit� dans la ligne de commande ne d�passe pas la la quantit� en stock
			if(ligneC.getQuantite()<produit.getQuantite()){
				int quantite =ligneC.getQuantite()+1;
				ligneC.setQuantite(quantite);
				
				double prix = produit.getPrix()*quantite;
				ligneC.setPrix(prix);
				
				ligneC.setPanier(panier);
				
				LCService.updateLigneCService(ligneC);

				//Actualisation des donn�es du panier
				int nbArticle = panier.getNbArticle()+1;
				panier.setNbArticle(nbArticle);
				
				double prixTotal = panier.getPrixTotal()+produit.getPrix();
				panier.setPrixTotal(prixTotal);
				
			}
		}

		//mise � jour du panier
		panierService.updatePanierService(panier);
		
		//R�cup�ration de la liste des cat�gories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//R�cup�ration de la liste des produits
		List<Produit> listeProd = produitService.getAllProduitService();
		model.addAttribute("prod_liste", listeProd);
		
		model.addAttribute("panierActif", panier);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("color", "green");
		model.addAttribute("loginColor", session.getAttribute("color"));

		
		return"c_accueil";
	
		
	}

	@RequestMapping(value="/panier/plus/{idProduit}",method=RequestMethod.GET)
	public String articlePlus(@PathVariable("idProduit") int id_produit, ModelMap model){
		
		//R�cup�rer le produit et le panier de la database
		Panier panier = panierService.getActivePanierService();
		Produit produit = produitService.getProduitByIdService(id_produit);
		
		//r�cup�rer la ligne de commande par le panier et le produit
		LigneCommande ligneC = LCService.getLigneCByProduitService(produit, panier);
		
		//Tester si la quantit� dans la ligne de commande ne d�passe pas la la quantit� en stock
		if(ligneC.getQuantite()<produit.getQuantite()){
			
			// mise � jour de la ligne de commande
			int quantite =ligneC.getQuantite()+1;
			ligneC.setQuantite(quantite);
			
			double prix = produit.getPrix()*quantite;
			ligneC.setPrix(prix);
			
			ligneC.setPanier(panier);
			
			LCService.updateLigneCService(ligneC);
			
			//mise � jour du panier
			int nbArticle = panier.getNbArticle()+1;
			panier.setNbArticle(nbArticle);
			
			double prixTotal = panier.getPrixTotal()+produit.getPrix();
			panier.setPrixTotal(prixTotal);
			
			panierService.updatePanierService(panier);
			
		}
		
		//Actualise le panier
		List<LigneCommande> listeLC = LCService.getLCsByPanierService(panier);
		model.addAttribute("liste", listeLC);
		
		model.addAttribute("panierActif", panier);
		return "c_panier";
	}

	@RequestMapping(value="/panier/moins/{idProduit}",method=RequestMethod.GET)
	public String articleMoins(@PathVariable("idProduit") int id_produit, ModelMap model){
		
		//R�cup�rer le produit et le panier de la database
		Panier panier = panierService.getActivePanierService();
		Produit produit = produitService.getProduitByIdService(id_produit);
		
		//r�cup�rer la ligne de commande par le panier et le produit
		LigneCommande ligneC = LCService.getLigneCByProduitService(produit, panier);
		
		if(ligneC.getQuantite()>1){
			
			// mise � jour de la ligne de commande
			int quantite =ligneC.getQuantite()-1;
			ligneC.setQuantite(quantite);
			
			double prix = produit.getPrix()*quantite;
			ligneC.setPrix(prix);
			
			ligneC.setPanier(panier);
			
			LCService.updateLigneCService(ligneC);
			
			//mise � jour du panier
			int nbArticle = panier.getNbArticle()-1;
			panier.setNbArticle(nbArticle);
			
			double prixTotal = panier.getPrixTotal()-produit.getPrix();
			panier.setPrixTotal(prixTotal);
			
			panierService.updatePanierService(panier);
		}
		//Actualise le panier
		List<LigneCommande> listeLC = LCService.getLCsByPanierService(panier);
		model.addAttribute("liste", listeLC);
		
		model.addAttribute("panierActif", panier);
		
		return "c_panier";
	}
	
	@RequestMapping(value="/panier/delete/{idProduit}",method=RequestMethod.GET)
	public String deleteLC(@PathVariable("idProduit") int id_produit, ModelMap model){
		
		//R�cup�rer le produit et le panier de la database
		Panier panier = panierService.getActivePanierService();
		Produit produit = produitService.getProduitByIdService(id_produit);
		
		//r�cup�rer la ligne de commande par le panier et le produit
		LigneCommande ligneC = LCService.getLigneCByProduitService(produit, panier);
		
		//Mise � jour du panier
		int nbArticle = panier.getNbArticle()-ligneC.getQuantite();
		panier.setNbArticle(nbArticle);
		
		double prixTotal = panier.getPrixTotal()-ligneC.getPrix();
		panier.setPrixTotal(prixTotal);
		
		panierService.updatePanierService(panier);
		
		//Supprimer la ligne de commande
		LCService.deleteLigneCService(ligneC.getId_LC());
		
		//Actualise le panier
		List<LigneCommande> listeLC = LCService.getLCsByPanierService(panier);
		model.addAttribute("liste", listeLC);
		
		model.addAttribute("panierActif", panier);
		
		return "c_panier";
	}

	@RequestMapping(value="/panier/deletePanier", method=RequestMethod.GET)
	public String deletePanier(ModelMap model){
		//R�cup�rer le panier de la database
		Panier panier = panierService.getActivePanierService();
		
		//R�cup�rer la liste des Ligne de Commande du panier
		List<LigneCommande> listeLC = LCService.getLCsByPanierService(panier);
		
		//Supprimer les lignes de commandes du panier
		for(LigneCommande lc:listeLC){
			LCService.deleteLigneCService(lc.getId_LC());
		}
		
		//Supprimer le panier actif
		panierService.deletePanierService(panier.getId_panier());
		
		//Cr�ation d'un nouveau panier vide
		panier = new Panier(0,0,true);
		panierService.addPanierService(panier);
		
		panier = panierService.getActivePanierService();
		model.addAttribute("panierActif", panier);
		
		return "c_panier";
	}

	@RequestMapping(value="/panier/commander", method=RequestMethod.GET)
	public String commander(ModelMap model, HttpServletRequest req){
		//R�cup�rer la session 
		HttpSession session = req.getSession();
		
		//R�cup�rer le client dans la session
		Client clientSession = (Client) session.getAttribute("clientSession");
		
		//R�cup�rer le panier acitf
		Panier panier = panierService.getActivePanierService();
		
		//Cr�er la commande en local
		Commande commande = new Commande();
		commande.setPanier(panier);
		
		//R�cup�rer la date
		Date date= new Date();
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();
		
		//Set la date de la commande
		commande.setDate_commande(new Date(year, month, day));
		
		List<LigneCommande> listeLC = LCService.getLCsByPanierService(panier);
		
		session.setAttribute("commandeSession", commande);
		
		model.addAttribute("liste", listeLC);
		model.addAttribute("panierActif", panier);
		model.addAttribute("commande", commande);
		model.addAttribute("client", clientSession);
		
		return "c_commande";
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String deconexion(ModelMap model, HttpServletRequest req){
		//R�cup�rer la session
		HttpSession session = req.getSession();
		
		//R�cup�rer le panier actif
		panier = panierService.getActivePanierService();
		
		//Supprimer le panier 
		panierService.deletePanierService(panier.getId_panier());
		
		//Cr�er un nouveau panier actif
		Panier panier2 = new Panier(0, 0, true);
		
		//Ajouter le panier actif au model
		model.addAttribute("panierActif", panier2);
		
		//R�cup�ration de la liste des cat�gories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//R�cup�ration de la liste des produits
		List<Produit> listeProd = produitService.getAllProduitService();
		model.addAttribute("prod_liste", listeProd);
		
		session.invalidate();
		
		return "c_accueil";
	}

	@RequestMapping(value="/panier/validerCommande", method=RequestMethod.GET)
	public String validerCommande(ModelMap model, HttpServletRequest req){
		HttpSession session =req.getSession();
		
		Panier panier = panierService.getActivePanierService();
		panier.setActive(false);
		
		Commande commande = (Commande) session.getAttribute("commandeSession");
		
		commande.setPanier(panier);
		
		panierService.updatePanierService(panier);
		
		commandeService.addCommandeService(commande);
		
		Panier panier2 = new Panier();
		panier2.setActive(true);
		panier2.setPrixTotal(0);
		panier2.setNbArticle(0);
		panierService.addPanierService(panier2);
		
		panier = panierService.getActivePanierService();
		List<LigneCommande> listeLC = LCService.getLCsByPanierService(panier);
		model.addAttribute("liste", listeLC);
		model.addAttribute("panierActif", panier);
		return "c_panier";
	}
}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
