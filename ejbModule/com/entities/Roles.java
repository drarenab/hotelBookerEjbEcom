package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Roles
 *
 */
@Entity

public class Roles implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String type;
	@OneToMany(mappedBy="role")
	private Collection<Administrateur> admin;
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Long getId() {
		return id;
	}


	
	public Collection<Administrateur> getAdmin() {
		return admin;
	}


	public void setAdmin(Collection<Administrateur> admin) {
		this.admin = admin;
	}

	

	public Roles(String type, Collection<Administrateur> admin) {
		super();
		this.type = type;
		this.admin = admin;
	}

	public Roles(String type) {
		super();
		this.type = type;
		this.admin = new HashSet<>();
	}

	public Roles() {
		super();
	}
   
}
