package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Entity implementation class for Entity: Utilisateur
 *
 */
@Entity

public class Utilisateur implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String region;
	private String codePostal;
	private String sex;
	@Pattern(regexp="#^0[1-9]([-. ]?[0-9]{2}){4}$#",
			message="{invalid.numTel}")//num tel au format fr
	private String numTel;
	@Pattern(regexp="#^[a-z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$#",
			message="{invalid.email}")//adresse mail en minuscule 
	private String email;
	private String password;
	
	@ManyToOne
	private Roles role;
	
	@OneToMany(mappedBy="utilisateur") 
	private Collection<Reservation> reservations;
	
	
	public Collection<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getNumTel() {
		return numTel;
	}


	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getId() {
		return id;
	}

	

	public Roles getRole() {
		return role;
	}


	public void setRole(Roles role) {
		this.role = role;
	}


	public Utilisateur(String nom, String prenom, String adresse, String ville, String region, String codePostal,
			String sex, String numTel, String email, String password, Roles role ,Collection<Reservation> reservations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.region = region;
		this.codePostal = codePostal;
		this.sex = sex;
		this.numTel = numTel;
		this.email = email;
		this.password = password;
		this.role = role;
		this.reservations=reservations;
				
	}
	public Utilisateur(String nom, String prenom, String adresse, String ville, String region, String codePostal,
			String sex, String numTel, String email, String password, Roles role ) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.region = region;
		this.codePostal = codePostal;
		this.sex = sex;
		this.numTel = numTel;
		this.email = email;
		this.password = password;
		this.role = role;
		this.reservations=new HashSet<>();
				
	}
	
	
	public Utilisateur() {
		super();
	}
   
}
