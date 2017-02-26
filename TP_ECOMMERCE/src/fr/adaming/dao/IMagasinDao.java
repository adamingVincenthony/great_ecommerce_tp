package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

/**
 * Contient les m�thodes utilis�es lors des op�rations de recherche de produits et de cat�gories effectu� par le client.
 * @author Vincent Bonillo & Anthony Josseaume
 *
 */
@Local
public interface IMagasinDao {
	
/**
 * Charge toutes les cat�gorie depuis la DB.
 * @return Un objet de type List<Categorie>.
 */
	public List<Categorie> getAllCategories();
	
	/**
	 * Charge tout les produits associ�s � une cat�gorie dans la DB.
	 * @param id_cat ID de la cat�gorie choisie, et correspondant � la Foreign Key dans la table produits de la DB.
	 * @return Un objet de type List<Produit>.
	 */
	public List<Produit> getAllProduitsByIdCategorie(long id_cat);
	
	/**
	 * Charge tout les produits de la DB correspondant au mot cl� entr� par le client. La recherche s'effectue dans la d�signation et la d�scription du produit.
	 * @param keyWord 
	 * @return Un objet de type List<Produit>.
	 */
	public List<Produit> getAllProduitsByKeyWord(String keyWord);

}
