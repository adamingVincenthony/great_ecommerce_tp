package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.entities.Categorie;

@Local
public interface IMagasinService {

	public List<Categorie> getAllCategories();
	
}
