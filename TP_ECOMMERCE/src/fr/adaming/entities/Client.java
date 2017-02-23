package fr.adaming.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	
	@Id
	@Column(name="id_cl")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idClient;
	
	private String NomClient;
	
	private String adresse;
	private String email;
	private String tel;
	

}
