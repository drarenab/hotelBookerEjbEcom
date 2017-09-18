package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Chambre
 *
 */
@Entity

public class Chambre implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long numero;
	private int nbLits;//nbLits de chambre (duo, individuel....)
	private Long etage;
	private int etat;//dispo a la location 0 non dispo 1
	private float prix; 
	@ManyToOne
	private Hotel hotel;
	@OneToMany(mappedBy="chambre") 
	private Collection<Photos> photos;

	@OneToMany(mappedBy="chambre") 
	private Collection<Reservation> reservationsChambre;
	
	
	
	public Collection<Reservation> getReservationsChambre() {
		return reservationsChambre;
	}

	public void setReservationsChambre(Collection<Reservation> reservationsChambre) {
		this.reservationsChambre = reservationsChambre;
	}

	public Collection<Photos> getPhotos() {
		return photos;
	}

	public void setPhotos(Collection<Photos> photos) {
		this.photos = photos;
	}


	public Long getId() {
		return id;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public void setEtage(Long etage) {
		this.etage = etage;
	}

	public long getNumero() {
		return numero;
	}
	
	public void setNumero(long numero) {
		this.numero = numero;
	}

	public int getnbLits() {
		return nbLits;
	}

	public void setnbLits(int nbLits) {
		this.nbLits = nbLits;
	}

	public long getEtage() {
		return etage;
	}

	public void setEtage(long etage) {
		this.etage = etage;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public float getPrix() {
		return prix;
	}



	public void setPrix(float prix) {
		this.prix = prix;
	}



	public Hotel getHotel() {
		return hotel;
	}



	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	

	public Chambre(Long numero, int nbLits, Long etage, int etat, float prix, Hotel hotel) {
		super();
		this.numero = numero;
		this.nbLits = nbLits;
		this.etage = etage;
		this.etat = etat;
		this.prix = prix;
		this.hotel = hotel;
		this.photos = new HashSet<>();;
		this.reservationsChambre = new HashSet<>();
	}

	
	public Chambre(Long numero, int nbLits, Long etage, int etat, float prix, Hotel hotel, Collection<Photos> photos,
			Collection<Reservation> reservationsChambre) {
		super();
		this.numero = numero;
		this.nbLits = nbLits;
		this.etage = etage;
		this.etat = etat;
		this.prix = prix;
		this.hotel = hotel;
		this.photos = photos;
		this.reservationsChambre = reservationsChambre;
	}

	public Chambre() {
		super();
	}
   
}
