package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.IMagasinService;

@ManagedBean(name = "magasinMB")
@ViewScoped
public class MagasinBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IMagasinService magasinService;

	private List<Categorie> listeCategories;
	private List<String> listeNomCat;
	private Map<String, Categorie> mapCategorie;
	private Categorie categorie;

	private List<Produit> listeProduits;

	private List<Produit> listeProduitsKW;

	private String keyWord = null;

	public MagasinBean() {
		super();
		listeCategories = new ArrayList<Categorie>();
		listeNomCat = new ArrayList<String>();
		mapCategorie = new HashMap<String, Categorie>();
		categorie = new Categorie();
		listeProduits = new ArrayList<Produit>();
		listeProduitsKW = new ArrayList<Produit>();
		
	}

	public List<Categorie> getListeCategories() {
		return listeCategories;
	}

	public void setListeCategories(List<Categorie> listeCategories) {
		this.listeCategories = listeCategories;
	}

	public IMagasinService getMagasinService() {
		return magasinService;
	}

	public void setMagasinService(IMagasinService magasinService) {
		this.magasinService = magasinService;
	}

	public List<String> getListeNomCat() {
		return listeNomCat;
	}

	public void setListeNomCat(List<String> listeNomCat) {
		this.listeNomCat = listeNomCat;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Map<String, Categorie> getMapCategorie() {
		return mapCategorie;
	}

	public void setMapCategorie(Map<String, Categorie> mapCategorie) {
		this.mapCategorie = mapCategorie;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	public List<Produit> getListeProduitsKW() {
		return listeProduitsKW;
	}

	public void setListeProduitsKW(List<Produit> listeProduitsKW) {
		this.listeProduitsKW = listeProduitsKW;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@PostConstruct
	public void getAllCategoriesMB() {

		System.out.println("je suis dans le MB");
		this.listeCategories = magasinService.getAllCategoriesService();
		System.out.println("je suis dans le MB2");

		for (Categorie cat : this.listeCategories) {
			System.out.println("je suis dans le MB3" + cat.getNomCategorie());
			this.listeNomCat.add(cat.getNomCategorie());
			System.out.println("je suis dans le MB4 " + cat.getNomCategorie());
			this.mapCategorie.put(cat.getNomCategorie(), cat);
		}
		System.out.println("je suis dans le MB4");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categorieMap", this.mapCategorie);
		System.out.println("je suis dans le MB4");

		System.out.println(this.categorie.getNomCategorie());
	}

	public String goToCategorie() {

		System.out.println(this.categorie.getNomCategorie());
		System.out.println(this.mapCategorie.size());
		this.categorie = this.mapCategorie.get(this.categorie.getNomCategorie());
		System.out.println(this.categorie);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categorieSes", this.categorie);

		this.listeProduits = magasinService.getAllProduitsByIdCategorieService(this.categorie.getIdCategorie());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitListe", listeProduits);

		return "goToCategorie";
	}

	public void allProduitsByKeyWordMB() {
		System.out.println("ds methode KW");
		
		StringBuilder keyWordBuild = new StringBuilder("%" + keyWord + "%");
		String keyWordSend = keyWordBuild.toString();
		
		System.out.println(keyWordSend);
		this.listeProduitsKW = magasinService.getAllProduitsByKeyWordService(keyWordSend);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitListeKW", listeProduitsKW);

	}
}
