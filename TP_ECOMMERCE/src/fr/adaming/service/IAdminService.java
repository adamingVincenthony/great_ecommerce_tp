package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;


@Local
public interface IAdminService {

	
	public Admin isExistService(Admin a);
	public Categorie ajouterCategorieService(Categorie c);
	public Produit ajouterProduitService(Produit p);
	public void supprimerProduitService(long id_p);
	public Produit modifierProduitService(Produit p);
	public List<Produit> getAllProduitService();
	public Produit getByIdService(long id_p);
	public Client enregistrerClientService(Client cl);
}
