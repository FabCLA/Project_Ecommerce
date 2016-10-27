package fr.adaming.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

public class ClassTestFab {

	public static void main(String[] args) {
		
		String context="C:\\Users\\inti0293\\git\\Project_Ecommerce\\E_Commerce\\src\\main\\webapp\\WEB-INF\\application-context.xml";

		ApplicationContext cxt = new FileSystemXmlApplicationContext(context);
		
		IClientService clientService = (IClientService) cxt.getBean("clientServiceBean");
		
		Client client = new Client(1,"pierre", "adresse", "mail", "password", 999999999);
		
		//lientService.addClientService(client);
		//clientService.updateClientService(client);
		//clientService.deleteClientService(1);
//		List<Client> liste = clientService.getAllClientService();
//		
//		for(Client c:liste){
//			System.out.println(c);
//		}
		//System.out.println(clientService.isExistService("jklj", "jkjl"));
	}

}
