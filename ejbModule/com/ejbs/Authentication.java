package com.ejbs;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import com.utilities.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Roles;
import com.entities.Utilisateur;
import com.utilities.*;
//import security.JwtSecurity;

@Stateless
@LocalBean
public class Authentication implements AuthenticationRemote{
	@PersistenceContext(name="primary")
    private EntityManager em;
	
	@Override
	public Utilisateur validUser(String username,String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		//System.out.println("validuser : hashedPassword:"+hashedPassword);
		
		TypedQuery<Utilisateur> query = em.createQuery("SELECT U FROM Utilisateur U where U.email=:login", Utilisateur.class)
				.setParameter("login", username);
	 
		List<Utilisateur> l=query.getResultList();
		if(l==null || l.isEmpty()) {
			return null;
		}
		
		//password validation
		
		
		System.out.println("Password validation started , password in db: "+l.get(0).getPassword());
		boolean matched = Util.validatePassword(password,l.get(0).getPassword());
		
		if(matched)
			return l.get(0);
		
		return null;
	}
	@Override
	public Roles getRoleFromLibelle(String libelle) {
		TypedQuery<Roles> query = em.createQuery("SELECT R FROM Roles R where R.libelle=:libelle", Roles.class)
				.setParameter("libelle", libelle);
	 
		List<Roles> r=query.getResultList();
		if(r!=null && !r.isEmpty())
			return r.get(0);
		else return null;
	}
	@Override
	public boolean registerUser(String nom,String prenom,String adresse,String ville,String region,String codePostal,String sexe,String numTel,String email,String pwd,String role) {
		//test if email adress not exist in database
		
		if (emailExists(email)) {
			return false;
		}
		Utilisateur u=new Utilisateur(nom, prenom, adresse, ville, region, codePostal, sexe,numTel, email,pwd,getRoleFromLibelle(role));
		em.persist(u);
		return true;
	}
	@Override
	public boolean emailExists(String email) {
		TypedQuery<Utilisateur> query=em.createQuery("SELECT U FROM Utilisateur U where U.email=:email",Utilisateur.class )
									.setParameter("email", email);
		
		List<Utilisateur> l=query.getResultList();
		if(l!=null && !l.isEmpty()) {
			return true;
		}
		else return false;
		
		//return (query.getResultList()!=null && !query.getResultList().isEmpty()); //retourne true si un user a deja utiliser cette adresse email
		
	}
	@Override
	public Utilisateur getUserFromId(Long id) {

		TypedQuery<Utilisateur> query=em.createQuery("SELECT U FROM Utilisateur U where U.id=:id",Utilisateur.class )
				.setParameter("id", id);

		List<Utilisateur> l=query.getResultList();

		if(l!=null && !l.isEmpty()) {

			return l.get(0);
		}

		return null;
	}
	
	
	@Override
	public Utilisateur getUserFormEmail(String email) {
		TypedQuery<Utilisateur> query=em.createQuery("SELECT U FROM Utilisateur U where U.email=:email",Utilisateur.class )
				.setParameter("email", email);

		List<Utilisateur> l=query.getResultList();

		if(l!=null && !l.isEmpty()) {

			return l.get(0);
		}

		return null;		
		
	}

	@Override
	public boolean updateUserPassword(Long id,String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		String hashedPassword = Util.generateStorngPasswordHash(password);
		System.out.println("Password:"+password);
		System.out.println("HashedPassword:"+hashedPassword);
		
		utilisateur.setPassword(hashedPassword);
		return true;
	}
	
}
