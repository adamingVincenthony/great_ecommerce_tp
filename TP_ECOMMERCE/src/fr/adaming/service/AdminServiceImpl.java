package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;

import fr.adaming.dao.AdminDaoImpl;
import fr.adaming.dao.IAdminDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;


public class AdminServiceImpl implements IAdminService{

	@EJB
	IAdminDao adminDao=new AdminDaoImpl();
	
	@Override
	public Admin isExistService(Admin a) {
		return adminDao.isExist(a);
	}

	@Override
	public Categorie ajouterCategorieService(Categorie c) {
		return adminDao.ajouterCategorie(c);
	}

	@Override
	public Produit ajouterProduitService(Produit p) {
		return adminDao.ajouterProduit(p);
	}

	@Override
	public void supprimerProduitService(int id_p) {
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
	public Produit getByIdService(int id_p) {
		return adminDao.getById(id_p);
	}
	
	

}
