package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IMagasinDao;
import fr.adaming.entities.Categorie;

@Stateful
public class MagasinServiceImpl implements IMagasinService {

	@EJB
	IMagasinDao magasinDao;
	
	@Override
	public List<Categorie> getAllCategories() {
		return magasinDao.getAllCategories();
	}

}
