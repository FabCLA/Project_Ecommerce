/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.service;

import java.util.List;


import fr.adaming.model.Categorie;

public interface ICategorieService {
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
	public void addCategorieService(Categorie categorie);
	public void deleteCategorieService(long id_client);
	public void updateCategorieService(Categorie categorie);
	public List<Categorie> getAllCategorieService();
	public Categorie getCategorieByNomService(String nom_cat);
//-------------------------------------------------------------------------------------------------------------

}
