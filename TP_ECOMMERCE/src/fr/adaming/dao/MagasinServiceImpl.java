package fr.adaming.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;

@Stateless
public class MagasinServiceImpl implements IMagasinDao {

	
	@EJB
	EntityManager em;
	
	//Récupérer toutes les catégories.
	@Override
	public List<Categorie> getAllCategories() {
		String req ="select c from Categorie c";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	
}
