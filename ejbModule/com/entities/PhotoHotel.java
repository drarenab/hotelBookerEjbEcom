package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Entity implementation class for Entity: PhotoHotel
 *
 */
@Entity

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id"
//)
public class PhotoHotel implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long nom;
	private String url;
	@ManyToOne 
	private Hotel hotel;
	
	
	
	public Long getNom() {
		return nom;
	}



	public void setNom(Long nom) {
		this.nom = nom;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Hotel getHotel() {
		return hotel;
	}



	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}



	public Long getId() {
		return id;
	}



	public PhotoHotel(Long nom, String url, Hotel hotel) {
		super();
		this.nom = nom;
		this.url = url;
		this.hotel = hotel;
	}

	

	public PhotoHotel() {
		super();
	}
   
}
