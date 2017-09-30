package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Entity implementation class for Entity: Photos
 *
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id"
//)
public class Photos implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private String url;
	@ManyToOne
	private Chambre chambre;
	
	 
	
	public Long getId() {
		return id;
	}


	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Chambre getChambre() {
		return chambre;
	}



	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}


	
	public Photos(String nom, String url, Chambre chambre) {
		super();
		this.nom= nom;
		this.url = url;
		this.chambre = chambre;
	}


	public Photos() {
		super();
	}
   
}
