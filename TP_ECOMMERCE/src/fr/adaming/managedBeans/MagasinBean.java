package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	private Map<String, Produit> panier;
	private Produit produit;
	private List<Produit> listePanier;

	private String keyWord = null;
	private int qtAjoute = 0;
	private double totalParProduit = 0;
	private double totalPanier = 0;

	public MagasinBean() {
		super();
		listeCategories = new ArrayList<Categorie>();
		listeNomCat = new ArrayList<String>();
		mapCategorie = new HashMap<String, Categorie>();
		categorie = new Categorie();
		listeProduits = new ArrayList<Produit>();
		listeProduitsKW = new ArrayList<Produit>();
		panier = new HashMap<String, Produit>();
		produit = new Produit();
		listePanier = new ArrayList<Produit>();
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

	public Map<String, Produit> getPanier() {
		return panier;
	}

	public void setPanier(Map<String, Produit> panier) {
		this.panier = panier;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQtAjoute() {
		return qtAjoute;
	}

	public void setQtAjoute(int qtAjoute) {
		this.qtAjoute = qtAjoute;
	}

	public List<Produit> getListePanier() {
		return listePanier;
	}

	public void setListePanier(List<Produit> listePanier) {
		this.listePanier = listePanier;
	}
	

	public double getTotalParProduit() {
		return totalParProduit;
	}

	public void setTotalParProduit(double totalParProduit) {
		this.totalParProduit = totalParProduit;
	}

	public double getTotalPanier() {
		return totalPanier;
	}

	public void setTotalPanier(double totalPanier) {
		this.totalPanier = totalPanier;
	}

	@PostConstruct
	public void initPanierAndCat() {

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

		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mapPanier") != null) {

			this.panier = (Map<String, Produit>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("mapPanier");

			Set<Entry<String, Produit>> setTemp = this.panier.entrySet();

			for (Entry<String, Produit> entry : setTemp) {
				this.listePanier.add(entry.getValue());
				this.totalPanier+= (entry.getValue().getPrix())*(entry.getValue().getQuantite());
				System.out.println("tot "+this.totalPanier);
				System.out.println(entry.getValue());
			}

			System.out.println("panier chargé");
		}

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

	public void ajouterPanier() {
		System.out.println(this.produit);

		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mapPanier") != null) {
			System.out.println("panier deja ds session");
			System.out.println(this.panier.size());

			this.panier = (Map<String, Produit>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("mapPanier");

			if (this.panier.containsKey(this.produit.getDesignation())) {
				System.out.println("produit deja dans panier");
				int newQuantite = (this.panier.get(this.produit.getDesignation())).getQuantite() + this.qtAjoute;

				System.out.println("nouvelle quantité: " + newQuantite);
				this.produit.setQuantite(newQuantite);

				this.panier.get(this.produit.getDesignation()).setQuantite(newQuantite);

			} else {
				System.out.println("produit nouveau ds panier");
				this.produit.setQuantite(this.qtAjoute);
				this.panier.put(this.produit.getDesignation(), this.produit);
			}

		} else {

			System.out.println("pas de panier existant -> vient d'etre créé");
			this.produit.setQuantite(this.qtAjoute);
			this.panier.put(this.produit.getDesignation(), this.produit);
		}
		System.out.println((this.panier.get(this.produit.getDesignation())).getQuantite());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mapPanier", this.panier);

	}

	public String goToProduit() {
		System.out.println(this.produit);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitSes", this.produit);

		return "goToProduit";
	}

	public String supprimerPanier() {
		System.out.println("tentatice de suppr");
		System.out.println(this.produit);
		System.out.println(this.panier.size());

		this.panier.remove(this.produit.getDesignation());
		System.out.println(this.panier.size());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mapPanier", this.panier);
		return "goToPanier";
	}
}
