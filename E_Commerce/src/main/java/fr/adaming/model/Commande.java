/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table
public class Commande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//------------------------------1_Les propri�t�s (champs, attributs)-------------------------------------------
	/**
	 * 1_Les propri�t�s (champs, attributs)
	 */
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id_commande;
		private Date date_commande;
		
		@OneToOne
		@JoinColumn(name="panier_id",referencedColumnName="id_panier")
		private Panier panier;
		
		@ManyToOne
		@JoinColumn(name="client_id",referencedColumnName="id_client")
		private Client client;
//-------------------------------------------------------------------------------------------------------------
//------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
		/**
		 * 
		 */
		public Commande() {
			super();
		}
		
		/**
		 * @param date_commande
		 * @param panier
		 * @param client
		 */
		public Commande(Date date_commande, Panier panier) {
			super();
			this.date_commande = date_commande;
		}
		
		/**
		 * @param id_commande
		 * @param date_commande
		 * @param panier
		 * @param client
		 */
		public Commande(long id_commande, Date date_commande) {
			super();
			this.id_commande = id_commande;
			this.date_commande = date_commande;
		}
//-------------------------------------------------------------------------------------------------------------
//------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
		/**
		 * @return the id_commande
		 */
		public long getId_commande() {
			return id_commande;
		}
		/**
		 * @param id_commande the id_commande to set
		 */
		public void setId_commande(Long id_commande) {
			this.id_commande = id_commande;
		}
		/**
		 * @return the date_commande
		 */
		public Date getDate_commande() {
			return date_commande;
		}
		/**
		 * @param date_commande the date_commande to set
		 */
		public void setDate_commande(Date date_commande) {
			this.date_commande = date_commande;
		}

		/**
		 * @return the panier
		 */
		public Panier getPanier() {
			return panier;
		}

		/**
		 * @param panier the panier to set
		 */
		public void setPanier(Panier panier) {
			this.panier = panier;
		}

		/**
		 * @return the client
		 */
		public Client getClient() {
			return client;
		}

		/**
		 * @param client the client to set
		 */
		public void setClient(Client client) {
			this.client = client;
		}
//-------------------------------------------------------------------------------------------------------------
//------------------------------4_M�thodes---------------------------------------------------------------------
	/**
	 * 4_M�thodes
	 */

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Commande [id_commande=" + id_commande + ", date_commande=" + date_commande + "]";
		}
		
//-------------------------------------------------------------------------------------------------------------
}
