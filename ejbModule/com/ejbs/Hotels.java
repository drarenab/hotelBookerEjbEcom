package com.ejbs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Chambre;
import com.utilities.*;

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
		            "SELECT C FROM Chambre C WHERE C.etat=1", Chambre.class);
		 
		 return query.getResultList();
	}
	
	@Override
	public List<Chambre> getRoomsForFilter(
			String ville,
			String checkInDate,
			String checkOutDate,
			int nbAdult,
			int nbChildren
			) {
		
		 TypedQuery<Chambre> query = em.createQuery(
		            "SELECT C FROM Chambre C "+
//		            "LEFT Join C.reservationsChambre R " +
		            "Join C.hotel H "+
		            "WHERE C.etat=1 AND H.ville=:ville AND C.nbLits>=:nbPlace "//+ 
//		            "AND  NOT(:dateDeb BETWEEN R.dateDeb AND R.dateFin " + 
//		            "OR :dateFin BETWEEN R.dateDeb AND R.dateFin )"
//		            + "OR R.chambre=C.id)"
				 	, Chambre.class)
				 	.setParameter("ville", ville)
				 	.setParameter("nbPlace", nbChildren+nbAdult);
//				 	.setParameter("dateDeb", Util.StringToDate(checkInDate))
//					.setParameter("dateFin", Util.StringToDate(checkOutDate));
		return query.getResultList();
		 
		
//		 return query.getResultList();
	}
	

}
