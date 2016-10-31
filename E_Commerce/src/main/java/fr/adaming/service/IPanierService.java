/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Panier;

public interface IPanierService {
	//-------------------------------------------------------------------------------------------------------------
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
		public void addPanierService(Panier panier);
		public void deletePanierService(long id_panier);
		public void updatePanierService(Panier panier);
		public List<Panier> getAllPanierService();
		public Panier getPanierByClientService(Client client);
		public int isExistService();
		public Panier getActivePanierService();
	//-------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------
}
