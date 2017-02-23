package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;


@Local
public interface IMagasinDao {
	

	public List<Categorie> getAllCategories();
	
	public List<Produit> getAllProduitsByIdCategorie(long id_cat);
	
	public List<Produit> getAllProduitsByKeyWord(String keyWord);

}
