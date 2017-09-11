package com.logic;

import javax.ejb.Remote;

@Remote
public interface RoomsRemote {
	public int add(int a,int b);
}
