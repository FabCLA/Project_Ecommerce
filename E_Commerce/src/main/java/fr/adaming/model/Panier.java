/**
 * 
 * @author CLAIN Fabien
 * Date : 15/10/2016
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Panier implements Serializable{
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
		private long id_panier;
		
		private Double prixTotal;
		
		@OneToOne(cascade=CascadeType.PERSIST)
		@JoinColumn(name="client_id",referencedColumnName="id_client")
		private Client clientP;
		
		@OneToMany(mappedBy="panier")
		private List<LigneCommande> listeLC;
		
		@OneToOne(mappedBy="panier")
		private Commande cmd;
//-------------------------------------------------------------------------------------------------------------
//------------------------------2_Les constructeurs------------------------------------------------------------	
	/**
	 * 2_Les constructeurs
	 */
		/**
		 * 
		 */
		public Panier() {
			super();
		}
		/**
		 * @param prixTotal
		 */
		public Panier(Double prixTotal) {
			super();
			this.prixTotal = prixTotal;
		}
		/**
		 * @param id_panier
		 * @param prixTotal
		 */
		public Panier(long id_panier, Double prixTotal) {
			super();
			this.id_panier = id_panier;
			this.prixTotal = prixTotal;
		}
//-------------------------------------------------------------------------------------------------------------
//------------------------------3_Les Getters et Setters-------------------------------------------------------
	/**
	 * 3_Les Getters et Setters
	 */
		/**
		 * @return the id_panier
		 */
		public long getId_panier() {
			return id_panier;
		}
		/**
		 * @param id_panier the id_panier to set
		 */
		public void setId_panier(Long id_panier) {
			this.id_panier = id_panier;
		}
		/**
		 * @return the prixTotal
		 */
		public Double getPrixTotal() {
			return prixTotal;
		}
		/**
		 * @param prixTotal the prixTotal to set
		 */
		public void setPrixTotal(Double prixTotal) {
			this.prixTotal = prixTotal;
		}
		/**
		 * @return the client
		 */
		public Client getClientP() {
			return clientP;
		}
		/**
		 * @param client the client to set
		 */
		public void setClientP(Client client) {
			this.clientP = client;
		}
		/**
		 * @return the listeLC
		 */
		public List<LigneCommande> getListeLC() {
			return listeLC;
		}
		/**
		 * @param listeLC the listeLC to set
		 */
		public void setListeLC(List<LigneCommande> listeLC) {
			this.listeLC = listeLC;
		}
		/**
		 * @return the cmd
		 */
		public Commande getCmd() {
			return cmd;
		}
		/**
		 * @param cmd the cmd to set
		 */
		public void setCmd(Commande cmd) {
			this.cmd = cmd;
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
			return "Panier [id_panier=" + id_panier + ", prixTotal=" + prixTotal + "]";
		}
//-------------------------------------------------------------------------------------------------------------
}
