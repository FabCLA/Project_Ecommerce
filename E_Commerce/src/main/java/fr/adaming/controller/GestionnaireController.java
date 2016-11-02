package fr.adaming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Gestionnaire;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.IGestionnaireService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping(value="/gestionnaire")
public class GestionnaireController {

	@Autowired
	private IProduitService prodService;
	
	@Autowired
	private ICategorieService categorieService;	
	
	@Autowired
	private IClientService clientService;	
	
	@Autowired
	private ICommandeService commandeService;
	
	@Autowired
	private ILigneCommandeService ligneCommandeService;
	
	
	@Autowired
	private IGestionnaireService gestionnaireService;
	
	//----------------------------------------------------------------------------------------------------------------
	//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
		/**
		 * 1_Les propriétés (champs, attributs)
		 */
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

	
//-------------------------------Identification gestionnaire-----------------------------------------	


		@RequestMapping(value="/login", method=RequestMethod.GET)
		public String identGest(ModelMap model){

			return "g_login";
		}
		
		@RequestMapping(value="/findGest", method=RequestMethod.POST)
		public String findGest(@ModelAttribute("gestionnaire") Gestionnaire gest, HttpServletRequest req, ModelMap model){
			//Vérifier si le client exist
			int i =gestionnaireService.isExistService(gest.getLogin(), gest.getMdp());
			
			if(i==1){
				List<Produit> liste = prodService.getAllProduitService();
				model.addAttribute("listeProd", liste);
				
				return "g_accueil";
			}else{
				return "g_login";
			}
		}
		
	
	
//-------------------------------Tableau de Produits-----------------------------------------	
	
	
		@RequestMapping(value="/gestAccueil", method=RequestMethod.GET)
		public String welcomeGest(ModelMap model){
			List<Produit> liste = prodService.getAllProduitService();
			model.addAttribute("listeProd", liste);
			
			return "g_accueil";
		}
		
//-------------------------------Tableau de Categories-----------------------------------------
		

		
		@RequestMapping(value="/gestCategories", method=RequestMethod.GET)
		public String categoriesGest(ModelMap model){
			
			List<Categorie> liste = categorieService.getAllCategorieService();
			model.addAttribute("listeCat", liste);
			
			return "g_categories";
		}
		
//-------------------------------Tableau de Clients-----------------------------------------



		@RequestMapping(value="/gestClients", method=RequestMethod.GET)
		public String clientsGest(ModelMap model){
			
			List<Client> liste = clientService.getAllClientService();
			model.addAttribute("listeClient", liste);
			
			return "g_clients";
		}
		
		
		
//-------------------------------Tableau des Commandes d'un Client-----------------------------------------


		@RequestMapping(value = "/gestCommandClient/{ClientID}", method = RequestMethod.GET)
		public String commandClient(@PathVariable("ClientID") long id_client, ModelMap model) {
						
			List<Commande> liste = commandeService.getCommandesByIdClientService(id_client);
			model.addAttribute("listeCommandClient", liste);
			
			return "g_commandClient";
		}
		

//-------------------------------Tableau des Lignes d'une Commande-----------------------------------------


		@RequestMapping(value = "/gestLignesCommand/{CommandeID}", method = RequestMethod.GET)
		public String lignesCommand(@PathVariable("CommandeID") long id_commande, ModelMap model) {
						
			List<LigneCommande> liste = ligneCommandeService.getLigneCByIdCommandeService(id_commande);
			model.addAttribute("listeLignesCommand", liste);
			
			return "g_lignesByCommande";
		}
		
		
//-------------------------------Ajouter Categorie-----------------------------------------		
		
		
		@RequestMapping(value="/formAjCatGest", method=RequestMethod.GET)
		public String initAjCatGest(ModelMap model){
			
			model.addAttribute("categorie", new Categorie());			
			
			return "g_ajouterCat";
		}
		
		
		@RequestMapping(value = "/gestAddCat", method = RequestMethod.POST)
		public String ajCatGest(@ModelAttribute("categorie") Categorie cat, ModelMap model) {
			
			categorieService.addCategorieService(cat);
			
			List<Categorie> liste = categorieService.getAllCategorieService();
			model.addAttribute("listeCat", liste);

			return "g_categories";

		}
		
		
//-------------------------------Ajouter Produit-----------------------------------------
		
		
		@RequestMapping(value="/formAjProdGest", method=RequestMethod.GET)
		public String initAjProdGest(ModelMap model){
			
			model.addAttribute("produit", new Produit());

			List<Categorie> liste = categorieService.getAllCategorieService();			
			model.addAttribute("categorieList", liste);
			
			
			return "g_ajouterProd";
		}
		
		
		@RequestMapping(value = "/gestAddProd", method = RequestMethod.POST)
		public String ajProdGest(@ModelAttribute("produit") Produit prod, ModelMap model) {
			
			String nomCat=prod.getCategorie().getNom();
			Categorie cat1=categorieService.getCategorieByNomService(nomCat);
			prod.setCategorie(cat1);
			prodService.addProduitService(prod);
			
			List<Produit> liste = prodService.getAllProduitService();
			model.addAttribute("listeProd", liste);

			return "g_accueil";

		}
		
		
		
//-------------------------------Supprimer Produit-----------------------------------------
		
		
		
		@RequestMapping(value="/formDelProdGest", method=RequestMethod.GET)
		public String delGest(ModelMap model){
			List<Produit> liste = prodService.getAllProduitService();
			model.addAttribute("listeProd", liste);
			
			return "g_suppProd";
		}
		
		
		@RequestMapping(value = "/gestDeleteProd/{ProduitID}", method = RequestMethod.GET)
		public String suppProdGest(@PathVariable("ProduitID") long id_produit, ModelMap model) {
			
			// suppression du produit de la bdd
			this.prodService.deleteProduitService(id_produit);

			List<Produit> liste = this.prodService.getAllProduitService();
			model.addAttribute("listeProd", liste);

			return "g_suppProd";
			
		}
		

//-------------------------------Supprimer Categorie-----------------------------------------
		
		
		@RequestMapping(value="/formDelCatGest", method=RequestMethod.GET)
		public String delCatGest(ModelMap model){
			
			List<Categorie> liste = categorieService.getAllCategorieService();
			model.addAttribute("listeCat", liste);
			
			return "g_suppCat";
		}
		
		
		@RequestMapping(value = "/gestDeleteCat/{CatID}", method = RequestMethod.GET)
		public String suppCatGest(@PathVariable("CatID") long id_categorie, ModelMap model) {
			
			// suppression de la categorie de la bdd
			this.categorieService.deleteCategorieService(id_categorie);
		
			List<Categorie> liste = categorieService.getAllCategorieService();
			model.addAttribute("listeCat", liste);
		
			return "g_suppCat";
			
		}

		
		
		
//-------------------------------Supprimer Client-----------------------------------------


		@RequestMapping(value="/formDelClientGest", method=RequestMethod.GET)
		public String delClientGest(ModelMap model){
			
			List<Client> liste = clientService.getAllClientService();
			model.addAttribute("listeClient", liste);
			
			return "g_suppClient";
		}
		
		
		@RequestMapping(value = "/gestDeleteClient/{ClientID}", method = RequestMethod.GET)
		public String suppClientGest(@PathVariable("ClientID") long id_client, ModelMap model) {
			
			// suppression du client de la bdd
			this.clientService.deleteClientService(id_client);
		
			List<Client> liste = clientService.getAllClientService();
			model.addAttribute("listeClient", liste);
		
			return "g_suppClient";
			
		}
		
		
//-------------------------------Modifier Produit-----------------------------------------		
		
		
		
		@RequestMapping(value="/formModif1", method=RequestMethod.GET)
		public String modifGest(ModelMap model){
			List<Produit> liste = prodService.getAllProduitService();
			model.addAttribute("listeProd", liste);
			
			return "g_modifProd1";
		}
		
		@RequestMapping(value = "/formModifProd/{ProduitID}", method = RequestMethod.GET)
		public String initModifProdGest(@PathVariable("ProduitID") long id_produit, ModelMap model) {
			
			Produit prod=this.prodService.getProduitByIdService(id_produit);
			model.addAttribute("prodAModif", prod);

			List<Categorie> liste = categorieService.getAllCategorieService();			
			model.addAttribute("categorieList", liste);

			return "g_modifProd";
			
		}
		
		@RequestMapping(value = "/gestModifProd", method =RequestMethod.POST)
		public String modifProdGest(@ModelAttribute("prodAModif") Produit prod, ModelMap model) {
			
			String nomCat=prod.getCategorie().getNom();
			Categorie cat1=categorieService.getCategorieByNomService(nomCat);
			prod.setCategorie(cat1);
			prodService.updateProduitService(prod);
			
			List<Produit> liste = prodService.getAllProduitService();
			model.addAttribute("listeProd", liste);

			return "g_modifProd";
		
		}
		
		
//		@RequestMapping(value = "/gestModifProd", method = RequestMethod.POST)
//		public String modifProdGest(@ModelAttribute("prodAModif") Produit prod, ModelMap model) {
//			
//			String nomCat=prod.getCategorie().getNom();
//			Categorie cat1=categorieService.getCategorieByNomService(nomCat);
//			prod.setCategorie(cat1);
//			Produit prod1=prod;
//			
//			prodService.deleteProduitService(prod.getId_produit());
//			prodService.addProduitService(prod1);
//			
//			List<Produit> liste = prodService.getAllProduitService();
//			model.addAttribute("listeProd", liste);
//
//			return "g_modifProd";
//
//		}
		
		
//		@RequestMapping(value = "/gestEditProd", method = RequestMethod.GET)
//		public ModelAndView editerEmploye(long id_produit) {
//			Produit p1 = this.prodService.getProduitByIdService(id_produit);
//			String viewName = "g_modifProd";
//			return new ModelAndView(viewName, "produit", p1);
//		}
		
		
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
}
