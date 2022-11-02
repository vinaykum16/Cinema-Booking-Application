package com.MovieBooking.Service;

import java.util.List;

import com.MovieBooking.entity.Auditorium;

public interface AuditoriumService {
	
	List<Auditorium> getAllAuditoriums();
	
	Auditorium getById(long id);
	
	Auditorium addAuditorium(Auditorium audi);
	
	Auditorium updateAuditorium(Auditorium audi, long id);
	
	String deleteById(long id);

}
