package fr.adaming.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;



public class ClassTestFab {

	public static void main(String[] args) {
		//R�cup�ration du context
		String context="C:\\Users\\inti0293\\git\\Project_Ecommerce\\E_Commerce\\src\\main\\webapp\\WEB-INF\\application-context.xml";
		ApplicationContext cxt = new FileSystemXmlApplicationContext(context);
		
	//--------------------------------------------Ajout des cat�gories---------------------------------------------------------------------
		//Instanciation des cat�gories
//			Categorie cat1 = new Categorie("Ordinateur");
//			Categorie cat2 = new Categorie("PC Portable");
//			Categorie cat3 = new Categorie("Tablette");
//			Categorie cat4 = new Categorie("Smartphone");
//			Categorie cat5 = new Categorie("P�riph�rique PC");
			
		//R�cup�ration du bean CategorieService
			ICategorieService catService = (ICategorieService) cxt.getBean("categorieServiceBean");
			
		//Ajout � la base de donn�e
//			catService.addCategorieService(cat1);
//			catService.addCategorieService(cat2);
//			catService.addCategorieService(cat3);
//			catService.addCategorieService(cat4);
//			catService.addCategorieService(cat5);
			
	//-------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------Ajout des produits(test)-----------------------------------------------------------------
			//Instanciation des produits
				Produit p1 = new Produit("p1", "Description", 1111111, 1, false);
				Produit p2 = new Produit("p2", "Description", 1111111, 1, false);
				Produit p3 = new Produit("p3", "Description", 1111111, 1, false);
				Produit p4 = new Produit("p4", "Description", 1111111, 1, false);
				Produit p5 = new Produit("p5", "Description", 1111111, 1, false);
				Produit p6 = new Produit("p6", "Description", 1111111, 1, false);
				Produit p7 = new Produit("p7", "Description", 1111111, 1, false);
				Produit p8 = new Produit("p8", "Description", 1111111, 1, false);
				Produit p9 = new Produit("p9", "Description", 1111111, 1, false);
				Produit p10 = new Produit("p10", "Description", 1111111, 1, false);
				
			//R�cup�ration du bean ProduitService
				IProduitService produitService = (IProduitService) cxt.getBean("produitServiceBean");
			
				
			//R�cup�rer les cat�gories de la database
				Categorie cat1 =catService.getCategorieByNomService("Ordinateur");
				Categorie cat2 =catService.getCategorieByNomService("PC Portable");
				Categorie cat3 =catService.getCategorieByNomService("Tablette");
				Categorie cat4 =catService.getCategorieByNomService("Smartphone");
				Categorie cat5 =catService.getCategorieByNomService("P�riph�rique PC");
				
			//Ajouter les produits au cat�gorie
				p1.setCategorie(cat1);
				p2.setCategorie(cat1);
				p3.setCategorie(cat2);
				p4.setCategorie(cat2);
				p5.setCategorie(cat3);
				p6.setCategorie(cat3);
				p7.setCategorie(cat4);
				p8.setCategorie(cat4);
				p9.setCategorie(cat5);
				p10.setCategorie(cat5);

			//Ajout � la base de donn�e
//				produitService.addProduitService(p1);
//				produitService.addProduitService(p2);
//				produitService.addProduitService(p3);
//				produitService.addProduitService(p4);
//				produitService.addProduitService(p5);
//				produitService.addProduitService(p6);
//				produitService.addProduitService(p7);
//				produitService.addProduitService(p8);
//				produitService.addProduitService(p9);
//				produitService.addProduitService(p10);	
				
				List<Produit> liste = produitService.getProduitByCategorieService(cat2);
				
				for(Produit p:liste){
					System.out.println(p);
				}
	//-------------------------------------------------------------------------------------------------------------------------------------		
				
				
				
				
	}

}
