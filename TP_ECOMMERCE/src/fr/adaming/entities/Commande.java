package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="commandes")
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cmd")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCommande;
	
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(name="fk_cl")
	private Client ClientCommande;

	
	//Constructors
	public Commande() {
		super();
	}

	public Commande(Date dateCommande, Client clientCommande) {
		super();
		this.dateCommande = dateCommande;
		ClientCommande = clientCommande;
	}

	public Commande(long idCommande, Date dateCommande, Client clientCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		ClientCommande = clientCommande;
	}

	//Getters and Setters
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
		return ClientCommande;
	}

	public void setClientCommande(Client clientCommande) {
		ClientCommande = clientCommande;
	}
	
	
	
}
