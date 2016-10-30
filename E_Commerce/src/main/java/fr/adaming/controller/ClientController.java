/**
 * 
 * @author CLAIN Fabien
 * Date :27/10/2016
 * 
 */
package fr.adaming.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
	
	private Panier panier = new Panier();
	private List<LigneCommande> listeLC=new ArrayList<>();
	
	@PostConstruct
	public void init(){
		panier.setListeLC(listeLC);
		
	}
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
	@RequestMapping(value="/accueil", method=RequestMethod.GET)
	public String accueilClient(ModelMap model){
		
		//R�cup�ration de la liste des cat�gories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//R�cup�ration de la liste des produits
		List<Produit> listeProd = produitService.getAllProduitService();
		model.addAttribute("prod_liste", listeProd);
		
		return "c_accueil";
	}
	
	@RequestMapping(value="/catProduit/{nomCategorie}", method=RequestMethod.GET)
	public String produitByCategorie(@PathVariable("nomCategorie") String nomCat, ModelMap model){
		
		//R�cup�ration de la liste des cat�gories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//R�cup�ration de la cat�gorie
		Categorie cat = catService.getCategorieByNomService(nomCat);
		
		//r�cup�ration de la liste des produits par leur cat�gorie
		List<Produit> listeProdByCat = produitService.getProduitByCategorieService(cat);
		
		model.addAttribute("prod_liste", listeProdByCat);
		
		return "c_accueil";
	}
	
	@RequestMapping(value="/panier", method=RequestMethod.GET)
	public String panier(ModelMap model){
		List<LigneCommande> listeLC = panier.getListeLC();
		model.addAttribute("liste", listeLC);
		
		return "c_panier";
	}
	
	@RequestMapping(value="/addProd/{id_produit}",method=RequestMethod.GET)
	public String addProduitInPanier(@PathVariable("id_produit") long produit_id, ModelMap model){
		//R�cup�ration du produit par l'ID
		Produit produit = produitService.getProduitByIdService(produit_id);
		
		//Cr�ation de la ligne de Commande
		LigneCommande ligneC =new LigneCommande(1, produit.getPrix());
		
		//Ajouter le produit � la ligne de commande
		ligneC.setProduit(produit);
		
		//Ajouter la ligne de commande au panier
		panier.getListeLC().add(ligneC);
		
		//R�cup�ration de la liste des cat�gories 
		List<Categorie> listeCat = catService.getAllCategorieService();
		model.addAttribute("cat_liste", listeCat);
		
		//R�cup�ration de la liste des produits
		List<Produit> listeProd = produitService.getAllProduitService();
		model.addAttribute("prod_liste", listeProd);
		
		return"c_accueil";
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}