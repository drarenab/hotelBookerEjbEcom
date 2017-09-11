package com.logic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Rooms
 */
@Stateless
@LocalBean
public class Rooms implements RoomsRemote {

    /**
     * Default constructor. 
     */
    public Rooms() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}
