package com.ejbs;

import javax.ejb.Remote;

import com.entities.Utilisateur;

@Remote
public interface AuthenticationRemote {
	public Utilisateur validUser(String username,String password);
}
