/**
 * 
 * @author CLAIN Fabien
 * Date :27/10/2016
 * 
 */
package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.LigneCommande;
@Repository
public class LigneCommandeDaoImpl implements ILigneCommandeDao {
//----------------------------------------------------------------------------------------------------------------
//---------------------------------1_Les propri�t�s (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propri�t�s (champs, attributs)
	 */
	@Autowired
	private SessionFactory sf;
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
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
//----------------------------------------------------------------------------------------------------------------
//---------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
	 */
	public void addLigneCDao(LigneCommande LigneC) {
		Session s = sf.getCurrentSession();
		s.save(LigneC);
	}

	public void deleteLigneCDao(long id_LigneC) {
		Session s = sf.getCurrentSession();
		LigneCommande ligneC = (LigneCommande) s.get(LigneCommande.class, id_LigneC);
		s.delete(ligneC);
	}

	public void updateLigneCDao(LigneCommande LigneC) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(LigneC);

	}
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

}
