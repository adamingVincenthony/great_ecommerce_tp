package fr.adaming.entities;

import java.io.Serializable;

public class LigneCommande implements Serializable{
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int quantite;
	private double prix;
	
	public LigneCommande() {
		super();
	}
	public LigneCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "LigneCommande [quantite=" + quantite + ", prix=" + prix + "]";
	}
	
	
	
}
