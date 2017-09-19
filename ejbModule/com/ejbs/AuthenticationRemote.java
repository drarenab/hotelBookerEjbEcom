package com.ejbs;

import javax.ejb.Remote;

import com.entities.Roles;
import com.entities.Utilisateur;

@Remote
public interface AuthenticationRemote {
	public Utilisateur validUser(String username,String password);
	public Roles getRoleFromLibelle(String libelle);
	public boolean registerUser(String nom,String prenom,String adresse,String ville,String region,String codePostal,String sexe,String numTel,String email,String pwd,String role) ;
}
