/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Client;


public interface IClientDao {
//------------------------------1_Les propri�t�s (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propri�t�s (champs, attributs)
	 */
//-------------------------------------------------------------------------------------------------------------
//------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
//-------------------------------------------------------------------------------------------------------------
//------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
//-------------------------------------------------------------------------------------------------------------
//------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
	 */
	public void addClientDao(Client client);
	public void deleteClientDao(long id_client);
	public void updateClientDao(Client client);
	public int isExistDao(String mail, String password);
	public List<Client> getAllClientDao();
	public Client getClientByIdentifiantDao(String mail, String password);
	public Client getClientByIdDao(long id_client);
//-------------------------------------------------------------------------------------------------------------
}
