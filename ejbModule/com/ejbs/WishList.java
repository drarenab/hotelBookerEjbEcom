package com.ejbs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Reservation;
import com.utilities.Util;

@Stateless
@LocalBean
public class WishList implements WishListRemote{
	@PersistenceContext(name="primary")
    private EntityManager em;
	
//	@EJB(lookup ="ejb:/HotelBookersEJB//Authentication!com.ejbs.AuthenticationRemote")
//	public AuthenticationRemote authenticationRemote;
	@Override
	public List<Reservation> getWishList() {
		TypedQuery<Reservation> query = em.createQuery(
				"SELECT R  FROM Reservation R "
				+"JOIN FETCH R.utilisateur u"
				+ " ORDER BY u.id"
				,Reservation.class);
				
	 
		List<Reservation> l=query.getResultList();
		return l;
	}
	@Override
	public List<Reservation> getWishListForClient(Long idClient) {
		TypedQuery<Reservation> query = em.createQuery(
				"SELECT R FROM Reservation R "
				+"JOIN R.utilisateur u "
				+ "WHERE u.id=:idClient ORDER BY R.dateDeb ASC",Reservation.class)
				.setParameter("idClient", idClient);
				
	 
		List<Reservation> l=query.getResultList();
		return l;
	}
}
