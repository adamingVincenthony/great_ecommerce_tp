package fr.adaming.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;

@Stateless
public class MagasinDaoImpl implements IMagasinDao {

	
	@PersistenceContext(unitName="TP_COMMERCE")
	EntityManager em;
	
	//R�cup�rer toutes les cat�gories.
	@Override
	public List<Categorie> getAllCategories() {
		String req ="select c from Categorie c";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	// ggggggggg
}
