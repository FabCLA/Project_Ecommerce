/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Categorie;


public interface ICategorieDao {
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
	public void addCategorieDao(Categorie categorie);
	public void deleteCategorieDao(long id_client);
	public void updateCategorieDao(Categorie categorie);
	public List<Categorie> getAllCategorieDao();
	public int getIdCategorieByNomDao(String nom_cat);
//-------------------------------------------------------------------------------------------------------------
}
