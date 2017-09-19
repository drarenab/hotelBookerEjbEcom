package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id"
//)
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
	@OneToMany(mappedBy="hotel",
			//cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private Collection<Chambre> chambres;
	@OneToMany(mappedBy="hotel",
			//cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private Collection<PhotoHotel> photos;
	
	public Collection<Chambre> getChambres() {
		return chambres;
	}



	public Collection<PhotoHotel> getPhotos() {
		return photos;
	}



	public void setPhotos(Collection<PhotoHotel> photos) {
		this.photos = photos;
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
			ChaineHotel chaineHotel, Collection<Chambre> chambres,Collection<PhotoHotel> photos) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.region = region;
		this.codePostal = codePostal;
		this.nbEtoile = nbEtoile;
		this.chaineHotel = chaineHotel;
		this.chambres = chambres;
		this.photos=photos;
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
		this.photos=new HashSet<>();
	}


	public Hotel() {
		super();
	}
   
}
