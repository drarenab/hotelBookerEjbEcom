package com.ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Chambre;
import com.entities.Hotel;
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
	
	@Override
	public boolean addRoom(Long num,int nbLits,Long etage,int etat,float prix, Long idHotel) {
		Chambre c;
		c=isRoomExist(num, idHotel);
		if(c!=null) {
			return false;
		}
		Hotel h=em.find(Hotel.class, idHotel);
		if(h==null)
			return false;//a changer
		c=new Chambre(num, nbLits, etage, etat, prix, h);
		em.persist(c);
		
		return true;
	}
	
	
	private Chambre isRoomExist(Long numeroChambre,Long idHotel) {
		//Chambre r=em.find(Chambre.class, idChambre);
		TypedQuery<Chambre> query=em.createQuery("SELECT C from Chambre C "
				+ "where C.numero=:numeroChambre AND C.hotel.id=:idHotel",Chambre.class)
				.setParameter("numeroChambre",numeroChambre)
				.setParameter("idHotel", idHotel);
		
		List<Chambre> l=query.getResultList();
		if(l!=null && !l.isEmpty()) {
			return l.get(0);
		}
		return null;
	}
}
