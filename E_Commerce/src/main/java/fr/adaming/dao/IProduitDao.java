/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.dao;

import java.util.List;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;


public interface IProduitDao {
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
	public void addProduitDao(Produit produit);
	public void deleteProduitDao(long id_produit);
	public void updateProduitDao(Produit produit);
	public List<Produit> getAllProduitDao();
	public List<Produit> getProduitByIdCategorieDao(long id_cat);
	public Produit getProduitByIdDao(long id_produit);
	public long getIdProduitByNomDao(String nomProduit);
//-------------------------------------------------------------------------------------------------------------
}
