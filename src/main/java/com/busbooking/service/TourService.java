package com.busbooking.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.busbooking.entities.Tour;

public interface TourService {

	public Tour save(Tour seat);

	public Page<Tour> findAll(Pageable bageable);

	public Page<Tour> findByStartPlaceContaining(String startPlace, Pageable pageable);

	public Page<Tour> findTourByEndPlaceContaining(String endPlace, Pageable pageable);

	public Page<Tour> findTourByStarttime(LocalDateTime startTime, Pageable pageable);

	public Page<Tour> findTourByStartPlaceAndEndplace(String startPlace, String endPlace, Pageable pageable);

	public Page<Tour> findTourByStartPlaceAndStartTime(String startPlace, LocalDateTime startTime, Pageable pageable);

	public Page<Tour> findTourByEndPlaceAndStartTime(String endPlace, LocalDateTime startTime, Pageable pageable);

	public Page<Tour> findTourByParam(String startPlace, String endPlace, LocalDateTime startTime, Pageable pageable);

	public Optional<Tour> findById(int idTour);

	public Tour findOne(int idTour);

	public void deleteAll();

	public void deleteById(int id);

}
