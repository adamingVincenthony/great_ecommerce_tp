package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;


@Local
public interface IMagasinDao {
	

	public List<Categorie> getAllCategories();

}
