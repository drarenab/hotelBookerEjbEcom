package com.ejbs;

import javax.ejb.Remote;

@Remote
public interface AdministrationRemote {

	boolean modifyEtatChambre(Long idchambre);

}
