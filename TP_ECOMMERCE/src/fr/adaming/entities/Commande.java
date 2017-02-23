package fr.adaming.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="commandes")
public class Commande {

	@Id
	@Column(name="id_cmd")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCommande;
	
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
}
