package com.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Utilisateur;

@Stateless
@LocalBean
public class Authentication implements AuthenticationRemote{
	@PersistenceContext(name="primary")
    private EntityManager em;
	
	

	
	public Utilisateur validUser(String username,String password) {
		TypedQuery<Utilisateur> query = em.createQuery("SELECT U FROM Utilisateur U where U.email=:login AND U.password=:pwd", Utilisateur.class)
				.setParameter("login", username)
				.setParameter("pwd", password);
	 
		List<Utilisateur> l=query.getResultList();
		if(l!=null && !l.isEmpty()) {
			return l.get(0);
		}
		else return null;
	}
}
