package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Classe représentant la structure de la table commandes dans la DB.
 * 
 * @author Vincent Bonillo & Anthony Josseaume
 *
 */
@Entity
@Table(name = "commandes")
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cmd")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCommande;

	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	@ManyToOne
	@JoinColumn(name = "fk_cl")
	private Client clientCommande;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="table_jointure_cm_pr",joinColumns=@JoinColumn(name="commande_id_fk"),inverseJoinColumns=@JoinColumn(name="produit_id_fk"))
	private List<Produit> produitsCommande;

	// Constructors
	public Commande() {
		super();
	}

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	public Commande(long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	// Getters and Setters
	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClientCommande() {
		return clientCommande;
	}

	public void setClientCommande(Client clientCommande) {
		this.clientCommande = clientCommande;
	}
	

	public List<Produit> getProduitsCommande() {
		return produitsCommande;
	}

	public void setProduitsCommande(List<Produit> produitsCommande) {
		this.produitsCommande = produitsCommande;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + "]";
	}

}
