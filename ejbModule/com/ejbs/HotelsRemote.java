package com.ejbs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;

import com.entities.Chambre;

@Remote
public interface HotelsRemote {
	
	
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
			);
	List<Chambre> getRoomsForFilter(String ville, String checkInDate, String checkOutDate, int nbAdult, int nbChildren);
}
