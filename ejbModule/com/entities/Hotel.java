package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity

public class Hotel implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String adresse;
	private String ville;
	private String region;
	private String codePostal;
	private String nbEtoile;
	@ManyToOne
	private ChaineHotel chaineHotel;
	@OneToMany(mappedBy="hotel")
	private Collection<Chambre> chambres;
	
	
	public Collection<Chambre> getChambres() {
		return chambres;
	}



	public void setChambres(Collection<Chambre> chambres) {
		this.chambres = chambres;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
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



	public String getNbEtoile() {
		return nbEtoile;
	}



	public void setNbEtoile(String nbEtoile) {
		this.nbEtoile = nbEtoile;
	}



	public Long getId() {
		return id;
	}



	public ChaineHotel getChaineHotel() {
		return chaineHotel;
	}



	public void setChaineHotel(ChaineHotel chaineHotel) {
		this.chaineHotel = chaineHotel;
	}



	public Hotel(String nom, String adresse, String ville, String region, String codePostal, String nbEtoile,
			ChaineHotel chaineHotel, Collection<Chambre> chambres) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.region = region;
		this.codePostal = codePostal;
		this.nbEtoile = nbEtoile;
		this.chaineHotel = chaineHotel;
		this.chambres = chambres;
	}

	public Hotel(String nom, String adresse, String ville, String region, String codePostal, String nbEtoile,
			ChaineHotel chaineHotel) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.region = region;
		this.codePostal = codePostal;
		this.nbEtoile = nbEtoile;
		this.chaineHotel = chaineHotel;
		this.chambres = new HashSet<>();
	}


	public Hotel() {
		super();
	}
   
}
