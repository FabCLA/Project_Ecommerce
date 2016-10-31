/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Client;
import fr.adaming.model.Panier;

public interface IPanierDao {
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
	public void addPanierDao(Panier panier);
	public void deletePanierDao(long id_panier);
	public void updatePanierDao(Panier panier);
	public List<Panier> getAllPanierDao();
	public Panier getPanierByClientDao(Client client);
	public int isExistDao();
	public Panier getActivePanierDao();
//-------------------------------------------------------------------------------------------------------------
}
