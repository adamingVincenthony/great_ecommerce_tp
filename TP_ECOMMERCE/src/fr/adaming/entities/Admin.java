package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Classe représentant la structure de la table categories dans la DB.
 * 
 * @author Vincent Bonillo & Anthony Josseaume
 *
 */
@Entity
@Table(name="administrateurs")
public class Admin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="id_admin")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String mdp;
	
	public Admin() {
		super();
	}

	public Admin(String nom, String mdp) {
		super();
		this.nom = nom;
		this.mdp = mdp;
	}

	public Admin(int id, String nom, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.mdp = mdp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", nom=" + nom + ", mdp=" + mdp + "]";
	}
	
	

}
