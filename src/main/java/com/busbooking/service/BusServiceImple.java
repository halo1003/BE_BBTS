package com.busbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busbooking.entities.Bus;
import com.busbooking.repo.BusRepository;

@Service
public class BusServiceImple implements BusService {

	@Autowired
	private BusRepository busRepository;

	@Autowired
	private SeatService seatService;

	/* ---------------- CREATE BUS ------------------------ */
	@Override
	public Bus save(Bus bus) {
		busRepository.save(bus);
		seatService.save(busRepository.getOne(bus.getId()));
		return bus;
	}

	/* ---------------- FIND BUS ------------------------ */
	@Override
	public List<Bus> findAll() {
		return busRepository.findAllByOrderByIdDesc();
	}

	/* ---------------- FIND BUS BY ID TOUR ------------------------ */
	@Override
	public List<Bus> findBusByIdTour(int idTour) {
		return busRepository.findBusByIdTour(idTour);
	}

	/* ---------------- FIND BUS BY ID ------------------------ */
	@Override
	public Bus findById(int idBus) {
		return busRepository.findById(idBus);
	}
}
