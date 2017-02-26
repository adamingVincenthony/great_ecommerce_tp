package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;

@Local
public interface IAdminDao {

	public Admin isExist(Admin a);
	public Categorie ajouterCategorie(Categorie c);
	public Produit ajouterProduit(Produit p);
	public void supprimerProduit(long id_p);
	public Produit modifierProduit(Produit p);
	public List<Produit> getAllProduit();
	public Produit getById(long id_p);
	public Client enregistrerClient(Client cl);
	
}	
