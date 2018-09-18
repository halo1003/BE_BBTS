package com.busbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.busbooking.entities.Ticket;
import com.busbooking.repo.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	/* ---------------- CREATE TICKET ------------------------ */
	@Override
	public Ticket save(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	/* ---------------- FIND TICKET BY USER ID ------------------------ */
	@Override
	public List<Ticket> findTicketByUserId(int userId) {
		return ticketRepository.findTicketByUserId(userId);
	}
	
	/* ---------------- FIND TOUR, BUS, SEAT ------------------------ */
//	@Override
//	public Optional<Ticket> findSeatForTicket(int idTour, int idBus, String numberSeat){
//		return ticketRepository.findSeatForTicket(idTour, idBus, numberSeat);
//	}
	
	@Override
	public Page<Ticket> findStartplaceByTicket(String startPlace, Pageable pageable) {
		return ticketRepository.findStartplaceByTicket(startPlace, pageable);
	}

	/* ---------------- FIND ALL TICKET ------------------------ */
	@Override
	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}
	
	/* ---------------- PAGEABLE USER BY NAME ------------------------ */
	@Override
	public Page<Ticket> findTicket(Pageable pageable) {
		return ticketRepository.findTicket(pageable);
	}

	/* ---------------- FIND TICKET BY ID ------------------------ */
	@Override
	public Optional<Ticket> findOne(int id) {
		return ticketRepository.findById(id);
	}

	/* ---------------- FIND SEAT DEPEND TICKET ------------------------ */
//	@Override
//	public Optional<Ticket> findSeatForTicket(int idTour, int idBus, int numberSeat) {
//		return ticketRepository.findSeatForTicket(idTour, idBus, numberSeat);
//	}

	/* ---------------- DELETE ALL TICKET ------------------------ */
	@Override
	public void deleteAll() {
		ticketRepository.deleteAll();
	}

	/* ---------------- DELETE BY ID TICKET ------------------------ */
	@Override
	public void deleteTicket(int id) {
		ticketRepository.deleteById(id);
	}
	
	/* ---------------- SET USER IN TICKET ------------------------ */
	public Optional<Ticket> setUser(int idUser){
		return null;
	}

}
