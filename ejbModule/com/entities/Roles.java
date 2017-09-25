package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Entity implementation class for Entity: Roles
 *
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id"
//)
public class Roles implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String libelle;
	@OneToMany(mappedBy="role")//,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Collection<Utilisateur> utilisateur;
	
	public String getlibelle() {
		return libelle;
	}


	public void setlibelle(String libelle) {
		this.libelle = libelle;
	}


	public Long getId() {
		return id;
	}


	
	public Collection<Utilisateur> getAdmin() {
		return utilisateur;
	}


	public void setAdmin(Collection<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

	

	public Roles(String libelle, Collection<Utilisateur> utilisateur) {
		super();
		this.libelle = libelle;
		this.utilisateur = utilisateur;
	}

	public Roles(String libelle) {
		super();
		this.libelle = libelle;
		this.utilisateur = new HashSet<>();
	}

	public Roles() {
		super();
	}
   
}
