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
		//Récupération du context
		String context="C:\\Users\\inti0293\\git\\Project_Ecommerce\\E_Commerce\\src\\main\\webapp\\WEB-INF\\application-context.xml";
		ApplicationContext cxt = new FileSystemXmlApplicationContext(context);
		
	//--------------------------------------------Ajout des catégories---------------------------------------------------------------------
		//Instanciation des catégories
//			Categorie cat1 = new Categorie("Ordinateur");
//			Categorie cat2 = new Categorie("PC Portable");
//			Categorie cat3 = new Categorie("Tablette");
//			Categorie cat4 = new Categorie("Smartphone");
//			Categorie cat5 = new Categorie("Périphérique PC");
			
		//Récupération du bean CategorieService
			ICategorieService catService = (ICategorieService) cxt.getBean("categorieServiceBean");
			
		//Ajout à la base de donnée
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
				
			//Récupération du bean ProduitService
				IProduitService produitService = (IProduitService) cxt.getBean("produitServiceBean");
			
				
			//Récupérer les catégories de la database
				Categorie cat1 =catService.getCategorieByNomService("Ordinateur");
				Categorie cat2 =catService.getCategorieByNomService("PC Portable");
				Categorie cat3 =catService.getCategorieByNomService("Tablette");
				Categorie cat4 =catService.getCategorieByNomService("Smartphone");
				Categorie cat5 =catService.getCategorieByNomService("Périphérique PC");
				
			//Ajouter les produits au catégorie
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

			//Ajout à la base de donnée
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
