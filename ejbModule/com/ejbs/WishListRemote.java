package com.ejbs;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Reservation;

@Remote
public interface WishListRemote {

	List<Reservation> getWishList();

	List<Reservation> getWishListForClient(Long idClient);

}
