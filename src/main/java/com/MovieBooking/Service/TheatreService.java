package com.MovieBooking.Service;

import java.util.List;

import com.MovieBooking.entity.Theatre;

public interface TheatreService {
	
	List<Theatre> getAllTheatre();
	
	Theatre getTheatreById(long id);
	
	Theatre addTheatre(Theatre theatre);
	
	Theatre updateTheatre(Theatre theatre, long id);
	
	void deleteTheatreById(long id);

}
