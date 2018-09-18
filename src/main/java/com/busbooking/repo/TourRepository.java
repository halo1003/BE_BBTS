package com.busbooking.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.busbooking.entities.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

	Page<Tour> findAllByOrderByIdDesc(Pageable pageable);

	@Query("SELECT t FROM Tour t WHERE t.id = :idTour")
	Tour findOne(@Param("idTour") int idTour);

	@Query("SELECT t FROM Tour t WHERE t.startPlace like %:startPlace%")
	Page<Tour> findTourByStartPlaceContaining(String startPlace, Pageable pageable);

	@Query("SELECT t FROM Tour t WHERE t.endPlace like %:endPlace%")
	Page<Tour> findTourByEndPlaceContaining(String endPlace, Pageable pageable);

	@Query("SELECT t FROM Tour t WHERE t.startTime = :startTime")
	Page<Tour> findTourByStarttime(@Param("startTime") LocalDateTime startTime, Pageable pageable);

	@Query("SELECT t FROM Tour t WHERE t.startPlace like %:startPlace% AND t.endPlace like %:endPlace%")
	Page<Tour> findTourByStartPlaceAndEndplace(@Param("startPlace") String startPlace,
			@Param("endPlace") String endPlace, Pageable pageable);

	@Query("SELECT t FROM Tour t WHERE t.startPlace like %:startPlace% AND t.startTime <= :startTime ")
	Page<Tour> findTourByStartPlaceAndStartTime(@Param("startPlace") String startPlace,
			@Param("startTime") LocalDateTime startTime, Pageable pageable);

	@Query("SELECT t FROM Tour t WHERE t.endPlace like %:endPlace% AND t.startTime <= :startTime ")
	Page<Tour> findTourByEndPlaceAndStartTime(@Param("endPlace") String endPlace,
			@Param("startTime") LocalDateTime startTime, Pageable pageable);

	@Query("SELECT t FROM Tour t WHERE t.startPlace like %:startPlace% OR t.endPlace = :endPlace OR t.startTime < :startTime ")
	Page<Tour> findTourByParam(@Param("startPlace") String startPlace, @Param("endPlace") String endPlace,
			@Param("startTime") LocalDateTime startTime, Pageable pageable);

}
