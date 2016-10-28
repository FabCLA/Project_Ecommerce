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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
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
	public String welcomeEmploye(ModelMap model){
		//Récupération de la liste des catégories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//Récupération de la liste des produits
		List<Produit> listeProd = produitService.getAllProduitService();
		model.addAttribute("prod_list", listeProd);
		return "c_accueil";
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
