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
			Reservation r=new Reservation(StringToDate(dateDeb), StringToDate(dateFin), nbEnfant, nbAdulte, u, c);
			em.persist(r);
		}
	}
	
	@Override
	public boolean isRoomAvailableForPeriod(Long idChambre,String dateDeb,String dateFin) {
		TypedQuery<Reservation> query = em.createQuery(
				"SELECT R FROM Reservation R "
				+ "Join R.chambre c "
				+ "where (:dateDeb BETWEEN R.dateDeb AND R.dateFin) "
				+ "OR (:dateFin BETWEEN R.dateDeb AND R.dateFin) "
				+ "AND c.id=:idChambre",Reservation.class)
				.setParameter("idChambre", idChambre)
				.setParameter("dateDeb", StringToDate(dateDeb))
				.setParameter("dateFin", StringToDate(dateFin));
	 
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
	private java.sql.Date StringToDate(String date){//a mettre dans une classe util 
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	        Date parsed = format.parse(date);
	        java.sql.Date sql = new java.sql.Date(parsed.getTime());
	        return sql;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
	}
}
