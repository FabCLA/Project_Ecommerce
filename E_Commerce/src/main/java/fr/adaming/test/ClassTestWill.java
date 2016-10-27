package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

public class ClassTestWill {

	public static void main(String[] args) {

		String context="C:\\Users\\inti0226\\git\\E_commerce\\E_Commerce\\src\\main\\webapp\\WEB-INF\\application-context.xml";
		
		ApplicationContext cxt = new FileSystemXmlApplicationContext(context);
		
		IClientService clientService = (IClientService) cxt.getBean("clientServiceBean");
		
		Client client = new Client("nom", "adresse", "mail", "password", 123132132);
		
		clientService.addClientService(client);
		
		
	}
}
