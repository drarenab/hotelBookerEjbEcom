package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Entity implementation class for Entity: Reservation
 *
 */
@Entity

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id"
//)
public class Reservation implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date dateDeb;
	private Date dateFin;
	private int nbEnfant;
	private int nbAdulte;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private Chambre chambre;
	
	
	public Date getDateDeb() {
		return dateDeb;
	}


	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public int getNbEnfant() {
		return nbEnfant;
	}


	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
	}

	public int getNbAdulte() {
		return nbAdulte;
	}


	public void setNbAdulte(int nbAdulte) {
		this.nbAdulte = nbAdulte;
	}
	
	public Utilisateur getutilisateur() {
		return utilisateur;
	}


	public void setutilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Chambre getChambre() {
		return chambre;
	}


	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}


	public Long getId() {
		return id;
	}

	
	
	public Reservation(Date dateDeb, Date dateFin, int nbEnfant,int nbAdulte, Utilisateur utilisateur, Chambre chambre) {
		super();
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.nbEnfant = nbEnfant;
		this.nbAdulte=nbAdulte;
		this.utilisateur = utilisateur;
		this.chambre = chambre;
	}


	public Reservation() {
		super();
	}
   
}
