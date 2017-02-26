package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;

/**
 * Contient les méthodes dao concernant l'authentification des administrateurs, toutes les méthodes de gestion des produits 
 * (ajouter, modifier, supprimer, trouver tous les produits et trouver par id), contient aussi la méthode pour enregistrer les données clients dans la bdd
 * 
 * @author Vincent Bonillo & Anthony Josseaume
 *
 */

@Local
public interface IAdminDao {

	/**
	 * Vérifie si les données entrées pour se connecter correspondent avec celles d'un des admin inscrits dans la bdd
	 * @param a : un admin avec un login et un mot de passe en attribut
	 * @return un admin avec un login et un mot de passe en attribut
	 */
	public Admin isExist(Admin a);
	
	/**
	 * Cette méthode permet d'instancier une catégorie et de l'enregistrer dans la base de données
	 * @param c : une catégorie en entrée avec les valeurs inscrites dans le formulaires par l'admin
	 * @return une catégorie
	 */
	public Categorie ajouterCategorie(Categorie c);
	/**
	 * Cette méthode permet d'instancier un produit et de l'enregistrer dans la base de données
	 * @param p : un produit en entrée avec les valeurs inscrites dans le formulaires par l'admin
	 * @return un produit
	 */
	public Produit ajouterProduit(Produit p);
	/**
	 * Permet de supprimer un produit de la bdd en le cherchant par son id
	 * @param id_p :l'id primaire d'un produit de la bdd
	 */
	public void supprimerProduit(long id_p);
	
	/**
	 * Permet de modifier les données d'un produit de la bdd
	 * @param p : un produit avec ses nouvelles valeurs en attribut
	 * @return un produit 
	 */
	public Produit modifierProduit(Produit p);
	/**
	 * Permet de récupérer la liste de tous les produits de la base de données
	 * @return une liste de produits
	 */
	public List<Produit> getAllProduit();
	/**
	 * Permet de chercher un produit par son id
	 * @param id_p: la clé primaire d'un produit
	 * @return un produit
	 */
	public Produit getById(long id_p);
	/**
	 * Permet d'enregistrer les données d'un client passant une commande dans la base de données
	 * @param cl
	 * @return
	 */
	public Client enregistrerClient(Client cl);
	
}	
