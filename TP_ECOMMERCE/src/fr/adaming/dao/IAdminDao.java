package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;

/**
 * Contient les m�thodes dao concernant l'authentification des administrateurs, toutes les m�thodes de gestion des produits 
 * (ajouter, modifier, supprimer, trouver tous les produits et trouver par id), contient aussi la m�thode pour enregistrer les donn�es clients dans la bdd
 * 
 * @author Vincent Bonillo & Anthony Josseaume
 *
 */

@Local
public interface IAdminDao {

	/**
	 * V�rifie si les donn�es entr�es pour se connecter correspondent avec celles d'un des admin inscrits dans la bdd
	 * @param a : un admin avec un login et un mot de passe en attribut
	 * @return un admin avec un login et un mot de passe en attribut
	 */
	public Admin isExist(Admin a);
	
	/**
	 * Cette m�thode permet d'instancier une cat�gorie et de l'enregistrer dans la base de donn�es
	 * @param c : une cat�gorie en entr�e avec les valeurs inscrites dans le formulaires par l'admin
	 * @return une cat�gorie
	 */
	public Categorie ajouterCategorie(Categorie c);
	/**
	 * Cette m�thode permet d'instancier un produit et de l'enregistrer dans la base de donn�es
	 * @param p : un produit en entr�e avec les valeurs inscrites dans le formulaires par l'admin
	 * @return un produit
	 */
	public Produit ajouterProduit(Produit p);
	/**
	 * Permet de supprimer un produit de la bdd en le cherchant par son id
	 * @param id_p :l'id primaire d'un produit de la bdd
	 */
	public void supprimerProduit(long id_p);
	
	/**
	 * Permet de modifier les donn�es d'un produit de la bdd
	 * @param p : un produit avec ses nouvelles valeurs en attribut
	 * @return un produit 
	 */
	public Produit modifierProduit(Produit p);
	/**
	 * Permet de r�cup�rer la liste de tous les produits de la base de donn�es
	 * @return une liste de produits
	 */
	public List<Produit> getAllProduit();
	/**
	 * Permet de chercher un produit par son id
	 * @param id_p: la cl� primaire d'un produit
	 * @return un produit
	 */
	public Produit getById(long id_p);
	/**
	 * Permet d'enregistrer les donn�es d'un client passant une commande dans la base de donn�es
	 * @param cl
	 * @return
	 */
	public Client enregistrerClient(Client cl);
	
}	
