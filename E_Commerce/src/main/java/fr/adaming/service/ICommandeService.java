/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

public interface ICommandeService {
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
		public void addCommandeService(Commande cmd);
		public void deleteComandeService(long id_cmd);
		public List<Commande> getCommandesByClientService(Client client);
	//-------------------------------------------------------------------------------------------------------------

}
