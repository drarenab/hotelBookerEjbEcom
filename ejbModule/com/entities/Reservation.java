package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reservation
 *
 */
@Entity

public class Reservation implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date dateDeb;
	private Date dateFin;
	private int nbPersonne;
	
	@ManyToOne
	private Client client;
	
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


	public int getNbPersonne() {
		return nbPersonne;
	}


	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
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

	
	
	public Reservation(Date dateDeb, Date dateFin, int nbPersonne, Client client, Chambre chambre) {
		super();
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.nbPersonne = nbPersonne;
		this.client = client;
		this.chambre = chambre;
	}


	public Reservation() {
		super();
	}
   
}
