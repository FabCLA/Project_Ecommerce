package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

public class ClassTestFab {

	public static void main(String[] args) {
		
		String context="C:\\Users\\inti0293\\git\\Project_Ecommerce\\E_Commerce\\src\\main\\webapp\\WEB-INF\\application-context.xml";

		ApplicationContext cxt = new ClassPathXmlApplicationContext(context);
		
		IClientService clientService = (IClientService) cxt.getBean("clientServiceBean");
		
		Client client = new Client("nom", "adresse", "mail", "password", 123132132);
		
		clientService.addClientService(client);
		
	}

}
