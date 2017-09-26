package com.ejbs;

import javax.ejb.Remote;

@Remote
public interface AdministrationRemote {

	public boolean modifyEtatChambre(Long idchambre);

	public boolean addRoom(Long num,int nbLits,Long etage,int etat,float prix, Long idHotel);

}
