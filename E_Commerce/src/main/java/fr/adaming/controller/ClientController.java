/**
 * 
 * @author CLAIN Fabien
 * Date :27/10/2016
 * 
 */
package fr.adaming.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping(value="/index")
public class ClientController {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
	@Autowired
	private ICategorieService catService; 
	
	@Autowired
	private IProduitService produitService;
	
	@Autowired
	private ILigneCommandeService LCService;
	
	@Autowired
	private IPanierService panierService;
	
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
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	@RequestMapping(value="/accueil", method=RequestMethod.GET)
	public String accueilClient(ModelMap model){
		//Récupération ou création d'un panier
		if(panierService.isExistService()==0){
			panier = new Panier();
			panier.setActive(true);
			panier.setNbArticle(0);
			panierService.addPanierService(panier);
			panier = panierService.getActivePanierService();
		}else{
			panier = panierService.getActivePanierService();
		}
		
		model.addAttribute("panierActif", panier);
		
		//Récupération de la liste des catégories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//Récupération de la liste des produits
		List<Produit> listeProd = produitService.getAllProduitService();
		model.addAttribute("prod_liste", listeProd);
		
		return "c_accueil";
	}
	
	@RequestMapping(value="/catProduit/{nomCategorie}", method=RequestMethod.GET)
	public String produitByCategorie(@PathVariable("nomCategorie") String nomCat, ModelMap model){
		
		//Récupération de la liste des catégories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//Récupération de la catégorie
		Categorie cat = catService.getCategorieByNomService(nomCat);
		
		//récupération de la liste des produits par leur catégorie
		List<Produit> listeProdByCat = produitService.getProduitByCategorieService(cat);
		
		model.addAttribute("prod_liste", listeProdByCat);
		
		return "c_accueil";
	}
	
	@RequestMapping(value="/panier", method=RequestMethod.GET)
	public String panier(ModelMap model){
		Panier panier = panierService.getActivePanierService();
		
		List<LigneCommande> listeLC = LCService.getLCsByPanierService(panier);
		model.addAttribute("liste", listeLC);
		model.addAttribute("panierActif", panier);
		return "c_panier";
	}

	@RequestMapping(value="/addProd/{id_produit}",method=RequestMethod.GET)
	public String addProduitInPanier(@PathVariable("id_produit") long produit_id, ModelMap model){
		//Récupération du produit par l'ID
		Produit produit = produitService.getProduitByIdService(produit_id);
		
		//Récupérer ou créer un panier
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
			
			//Actualisation des données du panier
			int nbArticle = panier.getNbArticle()+1;
			panier.setNbArticle(nbArticle);
			
			double prixTotal = panier.getPrixTotal()+produit.getPrix();
			panier.setPrixTotal(prixTotal);
			
		}else{
			LigneCommande ligneC =LCService.getLigneCByProduitService(produit, panier);
			
			//Tester si la quantité dans la ligne de commande ne dépasse pas la la quantité en stock
			if(ligneC.getQuantite()<produit.getQuantite()){
				int quantite =ligneC.getQuantite()+1;
				ligneC.setQuantite(quantite);
				
				double prix = produit.getPrix()*quantite;
				ligneC.setPrix(prix);
				
				ligneC.setPanier(panier);
				
				LCService.updateLigneCService(ligneC);

				//Actualisation des données du panier
				int nbArticle = panier.getNbArticle()+1;
				panier.setNbArticle(nbArticle);
				
				double prixTotal = panier.getPrixTotal()+produit.getPrix();
				panier.setPrixTotal(prixTotal);
				
			}
		}

		//mise à jour du panier
		panierService.updatePanierService(panier);
		
		//Récupération de la liste des catégories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//Récupération de la liste des produits
		List<Produit> listeProd = produitService.getAllProduitService();
		model.addAttribute("prod_liste", listeProd);
		
		model.addAttribute("panierActif", panier);
		
		return"c_accueil";
	
		
	}

	@RequestMapping(value="/panier/plus/{idProduit}",method=RequestMethod.GET)
	public String articlePlus(@PathVariable("idProduit") int id_produit, ModelMap model){
		
		//Récupérer le produit et le panier de la database
		Panier panier = panierService.getActivePanierService();
		Produit produit = produitService.getProduitByIdService(id_produit);
		
		//récupérer la ligne de commande par le panier et le produit
		LigneCommande ligneC = LCService.getLigneCByProduitService(produit, panier);
		
		//Tester si la quantité dans la ligne de commande ne dépasse pas la la quantité en stock
		if(ligneC.getQuantite()<produit.getQuantite()){
			
			// mise à jour de la ligne de commande
			int quantite =ligneC.getQuantite()+1;
			ligneC.setQuantite(quantite);
			
			double prix = produit.getPrix()*quantite;
			ligneC.setPrix(prix);
			
			ligneC.setPanier(panier);
			
			LCService.updateLigneCService(ligneC);
			
			//mise à jour du panier
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
		
		//Récupérer le produit et le panier de la database
		Panier panier = panierService.getActivePanierService();
		Produit produit = produitService.getProduitByIdService(id_produit);
		
		//récupérer la ligne de commande par le panier et le produit
		LigneCommande ligneC = LCService.getLigneCByProduitService(produit, panier);
		
		if(ligneC.getQuantite()>1){
			
			// mise à jour de la ligne de commande
			int quantite =ligneC.getQuantite()-1;
			ligneC.setQuantite(quantite);
			
			double prix = produit.getPrix()*quantite;
			ligneC.setPrix(prix);
			
			ligneC.setPanier(panier);
			
			LCService.updateLigneCService(ligneC);
			
			//mise à jour du panier
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
		
		//Récupérer le produit et le panier de la database
		Panier panier = panierService.getActivePanierService();
		Produit produit = produitService.getProduitByIdService(id_produit);
		
		//récupérer la ligne de commande par le panier et le produit
		LigneCommande ligneC = LCService.getLigneCByProduitService(produit, panier);
		
		//Mise à jour du panier
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
		//Récupérer le panier de la database
		Panier panier = panierService.getActivePanierService();
		
		//Récupérer la liste des Ligne de Commande du panier
		List<LigneCommande> listeLC = LCService.getLCsByPanierService(panier);
		
		//Supprimer les lignes de commandes du panier
		for(LigneCommande lc:listeLC){
			LCService.deleteLigneCService(lc.getId_LC());
		}
		
		//Supprimer le panier actif
		panierService.deletePanierService(panier.getId_panier());
		
		//Création d'un nouveau panier vide
		panier = new Panier(0,0,true);
		panierService.addPanierService(panier);
		
		panier = panierService.getActivePanierService();
		model.addAttribute("panierActif", panier);
		
		return "c_panier";
	}
}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
