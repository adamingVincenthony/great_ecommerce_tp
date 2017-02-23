package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cl")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idClient;
	
	private String NomClient;
	
	private String adresse;
	private String email;
	private String tel;
	
	@OneToMany(mappedBy="clientCommande")
	private List<Commande> listeCommandes;
	
	//Constructors

	public Client() {
		super();
	}

	public Client(String nomClient, String adresse, String email, String tel) {
		super();
		NomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	public Client(long idClient, String nomClient, String adresse, String email, String tel) {
		super();
		this.idClient = idClient;
		NomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	//Getters and Setters
	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return NomClient;
	}

	public void setNomClient(String nomClient) {
		NomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", NomClient=" + NomClient + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + "]";
	}

	
	
	
}
