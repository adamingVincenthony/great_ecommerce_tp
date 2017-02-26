package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Produit;
import fr.adaming.service.AdminServiceImpl;
import fr.adaming.service.IAdminService;

@ManagedBean(name="adminMB")
@ViewScoped
public class AdminManagedBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Admin admin;
	private Produit produit;
	private Categorie categorie;
	private Client client;
	
	@EJB
	IAdminService adminService=new AdminServiceImpl();
	
	
	List<Produit> listeP;
	List<Categorie> listeC;

	public AdminManagedBean() {
		this.admin=new Admin();
		this.produit=new Produit();
		this.categorie=new Categorie();
		this.setClient(new Client());
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public List<Produit> getListeP() {
		return listeP;
	}

	public void setListeP(List<Produit> listeP) {
		this.listeP = listeP;
	}

	public List<Categorie> getListeC() {
		return listeC;
	}

	public void setListeC(List<Categorie> listeC) {
		this.listeC = listeC;
	}
	
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public String connecter(){
		Admin admin=adminService.isExistService(this.admin);
		if(admin!=null){
			return "succes";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur de saisie de données"));
			return "echec";
		}
	}

	public String ajouterProduit(){
		produit.setCategorieProduit(this.categorie);
		adminService.ajouterProduitService(produit);
		return "ajouterProduit";
	}
	public String ajouterCategorie (){
		adminService.ajouterCategorieService(categorie);
		return "ajouterCategorie";
	}
	
	public String enregistrerClient(){
		adminService.enregistrerClientService(client);
		return "enregistrerClient";
	}
	
	public String supprimerProduit(){
		adminService.supprimerProduitService(produit.getId_produit());
		return "supprimerProduit";
	}
	
	public String modifierProduit(){
		adminService.modifierProduitService(produit);
		return "modifierProduit";
	}

	
	
	
}
