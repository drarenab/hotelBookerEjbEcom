package com.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Chambre;
import com.entities.Utilisateur;
@Stateless
@LocalBean
public class Administration implements AdministrationRemote{
	@PersistenceContext(name="primary")
    private EntityManager em;
	@Override	
	public boolean modifyEtatChambre(Long idChambre) {
		
		TypedQuery<Chambre> query = em.createQuery("SELECT C FROM Chambre C where C.id=:idChambre", Chambre.class)
				.setParameter("idChambre", idChambre);
	 
		List<Chambre> l=query.getResultList();
		if(l==null || l.isEmpty()) {
			return false;
		}
		//chambre existe modifier son etat
		Chambre c=l.get(0);
		int etat=c.getEtat()==0?1:0;
		c.setEtat(etat);
		em.persist(c);
		return true;
	}
}
