package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe représentant la structure de la table produits dans la DB.
 * 
 * @author Vincent Bonillo & Anthony Josseaume
 *
 */
@Entity
@Table(name="produits")
public class Produit implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_pr")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_produit;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	private boolean selectionne;

	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="categorie_id_fk", referencedColumnName="id_cat")
	private Categorie categorieProduit;

	
	@ManyToMany(mappedBy="produitsCommande")
	private List<Commande> commandeProduit;
	
	//Constructeurs vide, avec et sans id
	public Produit() {
		super();
	}

	public Produit(String designation, String description, double prix, Categorie categorieProduit) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.categorieProduit=categorieProduit;
		
	}
	
	public Produit(String designation, String description, double prix, int quantite, boolean selectionne) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		
	}

	public Produit(long id_produit, String designation, String description, double prix, int quantite,
			boolean selectionne) {
		super();
		this.id_produit = id_produit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		
	}
	
	//getters et setters

	public long getId_produit() {
		return id_produit;
	}

	public void setId_produit(long id_produit) {
		this.id_produit = id_produit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	

	
	public Categorie getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(Categorie categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	public List<Commande> getCommandeProduit() {
		return commandeProduit;
	}

	public void setCommandeProduit(List<Commande> commandeProduit) {
		this.commandeProduit = commandeProduit;
	}

	//autres méthodes
	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", designation=" + designation + ", description=" + description
				+ ", prix=" + prix + ", quantite=" + quantite + ", selectionne=" + selectionne +"]";
	}

	
	
}
