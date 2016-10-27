package fr.adaming.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
@Repository
public class ProduitDaoImpl implements IProduitDao {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propriétés (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propriétés (champs, attributs)
	 */
//----------------------------------------------------------------------------------------------------------------
//---------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
//----------------------------------------------------------------------------------------------------------------
//---------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_Méthodes---------------------------------------------------------------------
	/**
	 * 4_Méthodes
	 */
	public void addProduitDao(Produit produit) {
		// TODO Auto-generated method stub

	}

	public void deleteProduitDao(long id_produit) {
		// TODO Auto-generated method stub

	}

	public void updateProduitDao(Produit produit) {
		// TODO Auto-generated method stub

	}

	public List<Produit> getAllProduitDao() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produit> getProduitByCategorieDao(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	public Produit getProduitByIdDao(long id_produit) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getIdByNomProduitDao(String nomProduit) {
		// TODO Auto-generated method stub
		return 0;
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
}
