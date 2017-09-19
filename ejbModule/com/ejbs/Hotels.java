package com.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Chambre;

@Stateless
@LocalBean
public class Hotels implements HotelsRemote{
	
	@PersistenceContext(name="primary")
    private EntityManager em;
	
	@Override
	public List<Chambre> getALlRooms(
			//a verifier ce qu'on a besoin comme addresse avec Hamada
//			String postCode,
//			String state,
//			String city,
//			String checkInDate,
//			String checkOutDate,
//			String nbRoom,
//			String nbAdult,
//			String nbChildren
			) {
		
		 TypedQuery<Chambre> query = em.createQuery(
		            "SELECT C FROM Chambre C", Chambre.class);
		 
		 return query.getResultList();
	}

}
