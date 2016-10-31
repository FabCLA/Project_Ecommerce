package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.model.Gestionnaire;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IGestionnaireService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping(value="/gestionnaire")
public class GestionnaireController {

	@Autowired
	private IProduitService prodService;
	
	@Autowired
	private ICategorieService categorieService;
	
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
		@RequestMapping(value="/gestAccueil", method=RequestMethod.GET)
		public String welcomeGest(ModelMap model){
			List<Produit> liste = prodService.getAllProduitService();
			model.addAttribute("listeProd", liste);
			
			return "g_accueil";
		}
		
		
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
		
//		@RequestMapping(value = "/gestDeleteProd/{ProduitID}", method = RequestMethod.GET)
//		public String suppProdGest(@PathVariable("ProduitID") int IdProd, ModelMap model) {
//			
//			// suppression du produit de la bdd
//			this.prodService.deleteProduitService(IdProd);
//
//			List<Produit> liste = this.prodService.getAllProduitService();
//			model.addAttribute("listeProd", liste);
//
//			return "g_accueil";
//			
//		}
		
		
		@RequestMapping(value="/formDelProdGest", method=RequestMethod.GET)
		public String initDelProdGest(ModelMap model){
			
			model.addAttribute("produit", new Produit());

			List<Produit> liste = prodService.getAllProduitService();
			model.addAttribute("produitList", liste);
			
			
			return "g_suppProd";
		}
		
		@RequestMapping(value = "/gestDelProd", method = RequestMethod.POST)
		public String suppProdGest(@ModelAttribute("produit") Produit prod, ModelMap model) {
			
			prodService.deleteProduitService(prod.getId_produit());
			
			List<Produit> liste = prodService.getAllProduitService();
			model.addAttribute("listeProd", liste);

			return "g_accueil";

		}
		
		
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
}
