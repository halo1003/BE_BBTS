package com.busbooking.service;

import java.util.List;

import com.busbooking.entities.Bus;

public interface BusService {

	public Bus save(Bus bus);

	public List<Bus> findAll();
	
	public List<Bus> findBusByIdTour(int idTour);
	
	public Bus findById(int id);

}
