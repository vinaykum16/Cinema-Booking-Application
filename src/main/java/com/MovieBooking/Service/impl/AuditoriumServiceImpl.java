package com.MovieBooking.Service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.MovieBooking.entity.Auditorium;
import com.MovieBooking.exception.ResourceNotFoundException;
import com.MovieBooking.repository.AuditoriumRepo;
import com.MovieBooking.Service.AuditoriumService;

@Service
public class AuditoriumServiceImpl implements AuditoriumService{
	
	@Autowired
	private AuditoriumRepo audiRepo;
	
	@Override
	public List<Auditorium> getAllAuditoriums(){
		return audiRepo.findAll();
	}
	
	@Override
	public Auditorium getById(long id) {
		return audiRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Auditorium", "Id", id));
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public Auditorium addAuditorium(Auditorium audi) {
		return audiRepo.save(audi);
	}
	
	@Override
	public Auditorium updateAuditorium(Auditorium audi, long id) {
		Auditorium auditorium = audiRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Auditorium", "Id", id));
		auditorium.setScreen(audi.getScreen());
		auditorium.setSeatCount(audi.getSeatCount());
		auditorium.setSeats(audi.getSeats());
		auditorium.setTheatre(audi.getTheatre());
		return audiRepo.save(auditorium);
	}
	
	@Override
	public String deleteById(long id) {
		audiRepo.deleteById(id);
		return "Sucessfully Deleted!";
	}


}
