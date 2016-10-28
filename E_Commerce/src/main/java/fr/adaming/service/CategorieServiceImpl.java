/**
 * 
 * @author CLAIN Fabien
 * Date :27/10/2016
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;


@Service("categorieServiceBean")
@Transactional
public class CategorieServiceImpl implements ICategorieService{
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propri�t�s (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propri�t�s (champs, attributs)
	 */
	@Autowired
	private ICategorieDao categorieDao;
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
//---------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
	 */
	public void addCategorieService(Categorie categorie) {
		categorieDao.addCategorieDao(categorie);
		
	}

	public void deleteCategorieService(long id_cat) {
		categorieDao.deleteCategorieDao(id_cat);
		
	}

	public void updateCategorieService(Categorie categorie) {
		categorieDao.updateCategorieDao(categorie);
		
	}

	public List<Categorie> getAllCategorieService() {
		return categorieDao.getAllCategorieDao();
	}

	public Categorie getCategorieByNomService(String nom_cat) {
		return categorieDao.getCategorieByNomDao(nom_cat);
	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------


}
