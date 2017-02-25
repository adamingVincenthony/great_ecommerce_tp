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
	
	@EJB
	IAdminService adminService=new AdminServiceImpl();
	
	
	List<Produit> listeP;
	List<Categorie> listeC;

	public AdminManagedBean() {
		this.admin=new Admin();
		this.setProduit(new Produit());
		this.setCategorie(new Categorie());
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
	
	public String connecter(){
		Admin admin=adminService.isExistService(this.admin);
		if(admin!=null){
			return "succes";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur de saisie de données"));
			return "echec";
		}
	}

	public String ajouterProduit(Produit p){
		adminService.ajouterProduitService(p);
		return "ajouterProduit";
	}
	public String ajouterCategorie (Categorie c){
		adminService.ajouterCategorieService(c);
		return "ajouterCategorie";
	}
	
	public String supprimerProduit(int id_p){
		adminService.supprimerProduitService(id_p);
		return "supprimerProduit";
	}
	
	public String modifierProduit (Produit p){
		adminService.modifierProduitService(p);
		return "modifierProduit";
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
	
	
}
