package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Entity implementation class for Entity: ChaineHotel
 *
 */

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id"
//)
public class ChaineHotel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	
	@OneToMany(mappedBy="chaineHotel",cascade = CascadeType.ALL,fetch = FetchType.LAZY)//clé etrangére
	private List<Hotel> hotels;
	
	
	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
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


//	public ChaineHotel(String nom, Collection<Hotel> hotels) {
//		super();
//		this.nom = nom;
//		this.hotels = hotels;
//	}

	
//	public ChaineHotel(String no) {
//		super();
//		this.nom = nom;
//		this.hotels = new HashSet<>();
//	}


	public ChaineHotel() {
		super();
	}
   
}
