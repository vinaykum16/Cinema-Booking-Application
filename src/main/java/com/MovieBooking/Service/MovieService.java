package com.MovieBooking.Service;

import java.util.List;

import com.MovieBooking.entity.Movie;
import com.MovieBooking.entity.Screen;

public interface MovieService {
	
	List<Movie> getAllMovies();
	
	Movie getMovieById(long id);
	
	List<Screen> getScreenByMovieId(long id);
	
	Movie addMovie(Movie movie);
	
	Movie updateMovie(Movie movie,long id);
	
	void deleteMovie(long id);

}
