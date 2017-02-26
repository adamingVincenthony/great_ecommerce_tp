package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IMagasinDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
/**
 * 
 * @author Vincent Bonillo & Anthony Josseaume
 *@see IMagasinService
 */
@Stateful
public class MagasinServiceImpl implements IMagasinService {

	@EJB
	IMagasinDao magasinDao;
	
	@Override
	public List<Categorie> getAllCategoriesService() {
		return magasinDao.getAllCategories();
	}

	@Override
	public List<Produit> getAllProduitsByIdCategorieService(long id_cat) {
		return magasinDao.getAllProduitsByIdCategorie(id_cat);
	}

	@Override
	public List<Produit> getAllProduitsByKeyWordService(String keyWord) {
		return magasinDao.getAllProduitsByKeyWord(keyWord);
	}

}
