package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Stateless
public class MagasinDaoImpl implements IMagasinDao {

	@PersistenceContext(unitName = "TP_ECOMMERCE")
	EntityManager em;

	// Récupérer toutes les catégories.
	@Override
	public List<Categorie> getAllCategories() {
		String req = "select c from Categorie c";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Produit> getAllProduitsByIdCategorie(long id_cat) {
		String req = "select p from Produit p where p.categorieProduit.id_cat=:idProduit";
		Query query = em.createQuery(req);
		query.setParameter("idProduit", id_cat);
		return query.getResultList();
	}

	@Override
	public List<Produit> getAllProduitsByKeyWord(String keyWord) {
		String req = "select p from Produit p where p.designation like :pseudoKWord or p.description like :pseudoKWord";
		Query query = em.createQuery(req);
		query.setParameter("pseudoKWord", keyWord);
		List<Produit> listeProduits = query.getResultList();
		if (listeProduits.size() != 0) {
			return listeProduits;
		} else {
			return null;
		}
	}

}
