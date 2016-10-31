package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IProduitService;

public class ClassTestWill {

	public static void main(String[] args) {

		String context="C:\\Users\\inti0226\\git\\E_commerce\\E_Commerce\\src\\main\\webapp\\WEB-INF\\application-context.xml";
		
		ApplicationContext cxt = new FileSystemXmlApplicationContext(context);
		
//		IClientService clientService = (IClientService) cxt.getBean("clientServiceBean");
//		
//		Client client = new Client("nom", "adresse", "mail", "password", 123132132);
//		
//		clientService.addClientService(client);
		
		
		
		IProduitService produitService = (IProduitService) cxt.getBean("produitServiceBean");
//		ICategorieService categorieService = (ICategorieService) cxt.getBean("categorieServiceBean");
		
//		Categorie cat1=categorieService.getCategorieByNomService("Nettoyage");
//		
//		Produit produit = new Produit("nom", "description", 12, 50, true);
//		produit.setCategorie(cat1);
		
		produitService.deleteProduitService(9);
		
	}
}
