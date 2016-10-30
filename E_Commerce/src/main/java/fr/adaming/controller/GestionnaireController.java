package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.model.Gestionnaire;
import fr.adaming.model.Produit;
import fr.adaming.service.IGestionnaireService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping(value="/gestionnaire")
public class GestionnaireController {

	@Autowired
	private IProduitService prodService;
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
			
			
			return "g_ajouterProd";
		}
		
		
		@RequestMapping(value = "/gestAddProd", method = RequestMethod.POST)
		public String ajProdGest(@ModelAttribute("produit") Produit prod, ModelMap model) {

			prodService.addProduitService(prod);			
			
			List<Produit> liste = prodService.getAllProduitService();
			model.addAttribute("listeProd", liste);

			return "g_accueil";

		}
		
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
}
