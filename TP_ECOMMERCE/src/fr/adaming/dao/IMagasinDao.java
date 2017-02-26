package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

/**
 * Contient les méthodes utilisées lors des opérations de recherche de produits et de catégories effectué par le client.
 * @author Vincent Bonillo & Anthony Josseaume
 *
 */
@Local
public interface IMagasinDao {
	
/**
 * Charge toutes les catégorie depuis la DB.
 * @return Un objet de type List<Categorie>.
 */
	public List<Categorie> getAllCategories();
	
	/**
	 * Charge tout les produits associés à une catégorie dans la DB.
	 * @param id_cat ID de la catégorie choisie, et correspondant à la Foreign Key dans la table produits de la DB.
	 * @return Un objet de type List<Produit>.
	 */
	public List<Produit> getAllProduitsByIdCategorie(long id_cat);
	
	/**
	 * Charge tout les produits de la DB correspondant au mot clé entré par le client. La recherche s'effectue dans la désignation et la déscription du produit.
	 * @param keyWord 
	 * @return Un objet de type List<Produit>.
	 */
	public List<Produit> getAllProduitsByKeyWord(String keyWord);

}
