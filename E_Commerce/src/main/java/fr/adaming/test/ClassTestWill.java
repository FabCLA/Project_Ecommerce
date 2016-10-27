package fr.adaming.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.service.CategorieServiceImpl;
import fr.adaming.service.ICategorieService;

public class ClassTestWill {

	public static void main(String[] args) {

		String context="C:\\Users\\inti0226\\git\\E_commerce\\E_Commerce\\src\\main\\webapp\\WEB-INF\\application-context.xml";
		
		ApplicationContext cxt=new FileSystemXmlApplicationContext(context);
		
		ICategorieService catServ=new CategorieServiceImpl();
		
		
		
		
	}
}
