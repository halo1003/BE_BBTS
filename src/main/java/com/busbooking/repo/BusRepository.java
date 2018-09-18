package com.busbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.busbooking.entities.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

	List<Bus> findAllByOrderByIdDesc();
	
	Bus findById(int idBus);

	/* ---------------- FIND BUS IN TOUR ------------------------ */
	@Query(value = "SELECT * FROM bus b WHERE b.tour_idtour = :idTour", nativeQuery = true)
	List<Bus> findBusByIdTour(@Param("idTour") long idTour);
}
