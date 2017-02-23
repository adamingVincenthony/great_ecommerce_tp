package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.sun.xml.internal.bind.v2.runtime.Name;

import fr.adaming.entities.Categorie;
import fr.adaming.service.IMagasinService;

@ManagedBean(name="magasinMB")
@ViewScoped
public class MagasinBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IMagasinService magasinService;
	
	private List<Categorie> listeCategories;

	public MagasinBean() {
		super();
	}

	public List<Categorie> getListeCategories() {
		return listeCategories;
	}

	public void setListeCategories(List<Categorie> listeCategories) {
		this.listeCategories = listeCategories;
	}
	
	@PostConstruct
	public void getAllCategoriesMB(){
		System.out.println("je suis dans le MB");
		this.listeCategories=magasinService.getAllCategories();
	//	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categoriesListe", this.listeCategories);
		
	}
	

}
