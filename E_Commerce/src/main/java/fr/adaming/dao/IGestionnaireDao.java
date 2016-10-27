package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Gestionnaire;

public interface IGestionnaireDao {
	
	public List<Gestionnaire> isExist(String login, String mdp);

}
