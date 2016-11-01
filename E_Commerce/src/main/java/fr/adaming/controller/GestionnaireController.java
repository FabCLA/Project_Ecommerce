package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	//---------------------------------1_Les propri�t�s (champs, attributs)-------------------------------------------
		/**
		 * 1_Les propri�t�s (champs, attributs)
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
	//---------------------------------4_M�thodes---------------------------------------------------------------------
		/**
		 * 4_M�thodes
		 */
	
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
				
				
				@RequestMapping(value = "/gestDeleteCat/{ProduitID}", method = RequestMethod.GET)
				public String suppCatGest(@PathVariable("ProduitID") long id_categorie, ModelMap model) {
					
					// suppression de la categorie de la bdd
					this.categorieService.deleteCategorieService(id_categorie);

					List<Categorie> liste = categorieService.getAllCategorieService();
					model.addAttribute("listeCat", liste);

					return "g_suppCat";
					
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
