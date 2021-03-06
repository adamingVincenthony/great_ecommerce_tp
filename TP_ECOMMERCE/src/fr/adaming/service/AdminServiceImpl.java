package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import fr.adaming.dao.AdminDaoImpl;
import fr.adaming.dao.IAdminDao;
import fr.adaming.dao.IMagasinDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;

/**
 * 
 * @author Vincent Bonillo & Anthony Josseaume
 *@see IAdminService
 */
@Stateful
public class AdminServiceImpl implements IAdminService{

	@EJB
	IAdminDao adminDao=new AdminDaoImpl();
	
	@Override
	public Admin isExistService(Admin a) {
		return adminDao.isExist(a);
	}

	@Override
	public Categorie ajouterCategorieService(Categorie c) {
		System.out.println("SERVICE OK");
		return adminDao.ajouterCategorie(c);
	}

	@Override
	public Produit ajouterProduitService(Produit p) {
		return adminDao.ajouterProduit(p);
	}

	@Override
	public void supprimerProduitService(long id_p) {
		adminDao.supprimerProduit(id_p);
		
	}

	@Override
	public Produit modifierProduitService(Produit p) {
		return adminDao.modifierProduit(p);
	}

	@Override
	public List<Produit> getAllProduitService() {
		return adminDao.getAllProduit();
	}

	@Override
	public Produit getByIdService(long id_p) {
		return adminDao.getById(id_p);
	}

	@Override
	public Client enregistrerClientService(Client cl) {
		return adminDao.enregistrerClient(cl);
	}
	
	

}
