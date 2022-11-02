package com.MovieBooking.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.MovieBooking.entity.Theatre;
import com.MovieBooking.exception.ResourceNotFoundException;
import com.MovieBooking.repository.TheatreRepo;
import com.MovieBooking.Service.TheatreService;

@Service
public class TheatreServiceImpl implements TheatreService {
	
	@Autowired
	private TheatreRepo theRepo;
	
	@Override
	public List<Theatre> getAllTheatre(){
		return theRepo.findAll();
	}
	
	@Override
	public Theatre getTheatreById(long id) {
		return theRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Theatre", "Id", id));
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Theatre addTheatre(Theatre theatre) {
		return theRepo.save(theatre);
	}
	
	@Override
	public Theatre updateTheatre(Theatre theatre, long id) {
		Theatre theatres = theRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Theatre", "Id", id));
		theatres.setAuditorium(theatre.getAuditorium());
		theatres.setName(theatre.getName());
		
		return theRepo.save(theatres);
	}
	
	@Override
	public void deleteTheatreById(long id) {
		theRepo.deleteById(id);
	}

}
