package com.ejbs;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Chambre;
import com.entities.Reservation;
import com.entities.Utilisateur;
import com.utilities.Util;


@Stateless
@LocalBean
public class Booking implements BookingRemote{
	@PersistenceContext(name="primary")
    private EntityManager em;
	
	@EJB(lookup ="ejb:/HotelBookersEJB//Authentication!com.ejbs.AuthenticationRemote")
	public AuthenticationRemote authenticationRemote;
	
	@Override
	public void addRowInReservation(String dateDeb,String dateFin,int nbEnfant,int nbAdulte,long idChambre,String idUser) {

		if(!idUser.isEmpty()) {
			Utilisateur u=authenticationRemote.getUserFromId(Long.parseLong(idUser));
			Chambre c=getChambreFromId(idChambre);
			Reservation r=new Reservation(Util.StringToDate(dateDeb), Util.StringToDate(dateFin), nbEnfant, nbAdulte, u, c);
			em.persist(r);
		}
	}
	
	@Override
	public boolean isRoomAvailableForPeriod(Long idChambre,String dateDeb,String dateFin) {
		TypedQuery<Reservation> query = em.createQuery(
				"SELECT R FROM Reservation R "
//				+ "Join R.chambre c "
				+ "where R.chambre.id=:idChambre "
				+ "AND ((:dateFin>=R.dateDeb AND dateFin<R.dateFin) "

//				+ "AND (:dateFin BETWEEN R.dateDeb AND R.dateFin "
//				+ "OR :dateDeb BETWEEN R.dateDeb AND R.dateFin) ",Reservation.class)
				+ "OR (:dateDeb>=R.dateDeb AND :dateDeb<R.dateFin)) ",Reservation.class)

				.setParameter("idChambre", idChambre)
				.setParameter("dateDeb", Util.StringToDate(dateDeb))
				.setParameter("dateFin", Util.StringToDate(dateFin));
	 
		List<Reservation> l=query.getResultList();
		if(l!=null && !l.isEmpty()) {//cette periode contient au moins une reservation
			return false;
		}
		return true;//la periode est dispo
	}
	
	
	@Override
	public Chambre getChambreFromId(Long id) {
		TypedQuery<Chambre> query = em.createQuery("SELECT C FROM Chambre C where C.id=:id", Chambre.class)
				.setParameter("id", id);
	 
		List<Chambre> l=query.getResultList();
		if(l!=null && !l.isEmpty()) {
			return l.get(0);
		}
		return null;
	}
	

	@Override
	public boolean doUserOwnBooking(Long idUser,Long idBooking) {
		TypedQuery<Reservation> query = em.createQuery("SELECT R FROM Reservation R where "
				+ "R.id=:idBooking "
				+ "AND R.utilisateur.id =:idUser", Reservation.class)
				.setParameter("idBooking", idBooking)
				.setParameter("idUser", idUser);

		List<Reservation> bookingList = query.getResultList();
		if(bookingList != null && !bookingList.isEmpty()) {
			System.out.println(" not an empty list of bookings");
			return true;
		}
		
		return false;
	}

	@Override
	public boolean cancelBooking(Long idBooking) {
		Reservation reservation = em.find(Reservation.class,idBooking); // verify not null
//		try {
//			em.getTransaction().begin();
			em.remove(reservation);
//			em.getTransaction().commit();
			return true;
//		} catch(Exception e) {
//		    em.getTransaction().rollback();
//		    return false;
//		}
	}
	
	
}
