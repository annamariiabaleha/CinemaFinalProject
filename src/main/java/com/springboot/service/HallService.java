package com.springboot.service;

import java.util.List;

import com.springboot.entity.Hall;

public interface HallService {


	public void saveHall (Hall hall);
	
	public Hall findHallById (int id);
	
	public void deleteHall (Hall hall);
	
	public List<Hall> findAllHalls ();
	
	public List<Hall> findAllAvailableHalls ();
}
