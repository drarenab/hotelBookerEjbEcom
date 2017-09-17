package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChaineHotel
 *
 */

@Entity
public class ChaineHotel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	
	@OneToMany(mappedBy="chaineHotel")//clé etrangére
	private Collection<Hotel> hotels;
	
	
	public Collection<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(Collection<Hotel> hotels) {
		this.hotels = hotels;
	}


	public Long getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public ChaineHotel(String nom, Collection<Hotel> hotels) {
		super();
		this.nom = nom;
		this.hotels = hotels;
	}

	
	public ChaineHotel(String no) {
		super();
		this.nom = nom;
		this.hotels = new HashSet<>();
	}


	public ChaineHotel() {
		super();
	}
   
}
