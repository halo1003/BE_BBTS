package com.busbooking.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.busbooking.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	/* ---------------- FIND ALL ------------------------ */
	@Query(value = "SELECT ticket.*, tour.idtour, bus.busnumber " + "FROM ticket, tour, bus "
			+ "WHERE ticket.tour_idtour = tour.idtour "
			+ "AND ticket.bus_idbus = bus.idbus ORDER BY idticket DESC", nativeQuery = true)
	List<Ticket> findAll();
	
	@Query("SELECT t FROM Ticket t")
	Page<Ticket> findTicket(Pageable pageable);
	
	/* ---------------- FIND TOUR, BUS, SEAT ------------------------ */
//	@Query(value = "SELECT s.idseat FROM seat s INNER JOIN bus b ON s.bus_idbus = b.idbus INNER JOIN tour t ON b.tour_idtour = t.idtour WHERE t.idtour = :idTour AND b.idbus = :idBus AND s.numberseat = :numberSeat", nativeQuery = true)
//	Optional<Ticket> findSeatForTicket(@Param("idTour") int idTour, @Param("idBus") int idBus,
//			@Param("numberSeat") String numberSeat);
	
	@Query(value = "SELECT * FROM ticket t INNER JOIN tour tr ON t.tour_idtour = tr.idtour WHERE tr.startplace = :startPlace", nativeQuery = true)
	Page<Ticket> findStartplaceByTicket(@Param("startPlace") String startPlace, Pageable pageable);
	
	
	/* ---------------- FIND TICKET BY USER ID ------------------------ */
	@Query(value = "SELECT t.* FROM Ticket t WHERE t.user_id = :userId", nativeQuery = true)
	List<Ticket> findTicketByUserId(@Param("userId") int userId);

	/* ---------------- FIND TOUR, BUS, SEAT ------------------------ */
//	@Query(value = "SELECT t.startplace,t.endplace,t.starttime,t.endtime,b.busnumber,b.totalseat,s.numberseat,s.active "
//			+ "FROM seat s INNER JOIN bus b "
//			+ "ON s.bus_idbus = b.idbus "
//			+ "INNER JOIN tour t "
//			+ "ON b.tour_idtour = t.idtour "
//			+ "WHERE t.idtour = :idTour "
//			+ "AND b.idbus = :idBus "
//			+ "AND s.numberseat = :numberSeat", nativeQuery = true)
//	@Query(value = "SELECT t.startplace,t.endplace,t.starttime,t.endtime,b.busnumber,b.totalseat,s.numberseat,s.active FROM seat s INNER JOIN bus b ON s.bus_idbus = b.idbus INNER JOIN tour t ON b.tour_idtour = t.idtour WHERE t.idtour = :idTour AND b.idbus = :idBus AND s.numberseat = :numberSeat", nativeQuery = true)
//	Optional<Ticket> findSeatForTicket(@Param("idTour") int idTour, @Param("idBus") int idBus,
//			@Param("numberSeat") int numberSeat);
}
