package com.ejbs;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.ejb.Remote;

import com.entities.Roles;
import com.entities.Utilisateur;

@Remote
public interface AuthenticationRemote {
	public Utilisateur validUser(String username,String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
	public Roles getRoleFromLibelle(String libelle);
	public boolean registerUser(String nom,String prenom,String adresse,String ville,String region,String codePostal,String sexe,String numTel,String email,String pwd,String role) throws NoSuchAlgorithmException, InvalidKeySpecException ;
	public Utilisateur getUserFromId(Long id) ;
	public Utilisateur getUserFormEmail(String email);
	public boolean emailExists(String email);
	public boolean updateUserPassword(Long id,String password) throws NoSuchAlgorithmException, InvalidKeySpecException;

}
