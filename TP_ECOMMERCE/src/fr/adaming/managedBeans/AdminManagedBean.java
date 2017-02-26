package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

/**
 * ManagedBean contenant les m�thodes permettant aux administrateurs de se loguer et d'apporter des modifications aux �l�ments
 * de la base de donn�es (produits, cat�gorie) et une m�thode permettant d'enregistrer les informations des clients
 * @author Vincent Bonillo & Anthony Josseaume
 *@see IAdminDao
 */

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
	private Map<String, Categorie> mapCategorie;
	
	@EJB
	IAdminService adminService=new AdminServiceImpl();
	
	
	List<Produit> listeP;
	List<Categorie> listeC;

	public AdminManagedBean() {
		admin=new Admin();
		produit=new Produit();
		categorie=new Categorie();
		client=new Client();
		mapCategorie = new HashMap<String, Categorie>();
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
	
	
	public Map<String, Categorie> getMapCategorie() {
		return mapCategorie;
	}

	public void setMapCategorie(Map<String, Categorie> mapCategorie) {
		this.mapCategorie = mapCategorie;
	}

	/**
	 * M�thode v�rifiant l'existence d'un admin avec les param�tres saisient dans le formulaire dans la bdd
	 * @return un string d�clant un cas de navigation 
	 */
	public String connecter(){
		Admin admin=adminService.isExistService(this.admin);
		if(admin!=null){
			return "succes";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur de saisie de donn�es"));
			return "echec";
		}
	}

	/**
	 * M�thode permettant d'enregistrer les donn�es lors de l'ajout d'un produit dans la bdd
	 * @return un string pouvant d�clencher un cas de navigation
	 */
	public String ajouterProduit(){
		this.categorie = this.mapCategorie.get(this.categorie.getNomCategorie());
		this.produit.setCategorieProduit(categorie);
		adminService.ajouterProduitService(produit);
		return "ajouterProduit";
	}
	/**
	 * M�thode permettant d'enregistrer les donn�es lors de l'ajout d'une cat�gorie dans la bdd
	 * @return un string pouvant d�clencher un cas de navigation
	 */
	public String ajouterCategorie (){
		adminService.ajouterCategorieService(categorie);
		return "ajouterCategorie";
	}
	/**
	 * M�thode permettant d'enregistrer les donn�es lors de l'ajout d'un client dans la bdd
	 * @return un string pouvant d�clencher un cas de navigation
	 */
	public String enregistrerClient(){
		adminService.enregistrerClientService(client);
		return "enregistrerClient";
	}
	/**
	 * M�thode permettant de supprimer les donn�es d'un produit dans la bdd
	 * @return un string pouvant d�clencher un cas de navigation
	 */
	public String supprimerProduit(){
		adminService.supprimerProduitService(produit.getId_produit());
		return "supprimerProduit";
	}
	/**
	 * M�thode permettant d'enregistrer de nouvelles donn�es lors de la modification d'un produit dans la bdd
	 * @return un string pouvant d�clencher un cas de navigation
	 */
	public String modifierProduit(){
		adminService.modifierProduitService(produit);
		return "modifierProduit";
	}

	
	
	
}
