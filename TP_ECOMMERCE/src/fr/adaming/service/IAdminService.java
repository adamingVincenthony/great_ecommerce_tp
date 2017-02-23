package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;


@Local
public interface IAdminService {

	
	public Admin isExistService(Admin a);
	public Categorie ajouterCategorieService(Categorie c);
	public Produit ajouterProduitService(Produit p);
	public void supprimerProduitService(int id_p);
	public Produit modifierProduitService(Produit p);
	public List<Produit> getAllProduitService();
	public Produit getByIdService(int id_p);
}
