package com.logic;

import javax.ejb.Remote;

import com.entities.Room;

@Remote
public interface DbRemote {
	
	public java.util.List<Room> getAllRooms();
	//public String getAllRooms();
}
