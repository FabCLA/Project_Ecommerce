package fr.adaming.service;

import java.util.List;


import fr.adaming.model.Gestionnaire;

public interface IGestionnaireService {
	
	public List<Gestionnaire> isExistService(String login, String mdp);

}
