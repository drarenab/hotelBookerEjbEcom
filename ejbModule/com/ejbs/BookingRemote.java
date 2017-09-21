package com.ejbs;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import com.entities.Chambre;

@Remote
public interface BookingRemote {
	public void addRowInReservation(String dateDeb,String dateFin,int nbEnfant,int nbAdulte,long idChambre,String token);
	public boolean isRoomAvailableForPeriod(Long idChambre,String dateDeb,String dateFin);
	public Chambre getChambreFromId(Long id);
}
