package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateless
public class AdminDaoImpl implements IAdminDao{

	
	@PersistenceContext(unitName="TP_ECOMMERCE")
	EntityManager em;
	
	@Override
	public Admin isExist(Admin a) {
		String req="select a from Admin a where a.nom=:pNom and a.mdp=:pMdp";
		Query query=em.createQuery(req);
		query.setParameter("pNom", a.getNom());
		query.setParameter("pMdp", a.getMdp());
		
		List<Admin> listeAdmins=query.getResultList();
		if(listeAdmins.size()!=0){
			Admin adminRetour=listeAdmins.get(0);
			return adminRetour;
		}else{
			return null;
		}
	}

	@Override
	public Categorie ajouterCategorie(Categorie c) {
		em.persist(c);
		return null;
	}

	@Override
	public Produit ajouterProduit(Produit p) {
		em.persist(p);
		return null;
	}

	@Override
	public void supprimerProduit(long id_p) {
		em.remove(em.find(Produit.class, id_p));
	}

	@Override
	public Produit modifierProduit(Produit p) {
		em.merge(p);
		return null;
	}

	@Override
	public List<Produit> getAllProduit() {
		String req="select p from Produit p";
		Query query=em.createQuery(req);
		List<Produit> listeP=query.getResultList();
		
		return listeP;
	}

	@Override
	public Produit getById(long id_p) {
		return em.find(Produit.class, id_p);
	}

}
