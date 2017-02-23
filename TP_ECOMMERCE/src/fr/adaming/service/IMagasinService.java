package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Local
public interface IMagasinService {

	public List<Categorie> getAllCategoriesService();
	
	public List<Produit> getAllProduitsByIdCategorieService(long id_cat);
	
	public List<Produit> getAllProduitsByKeyWordService(String keyWord);
}
