package com.MovieBooking.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.MovieBooking.entity.Movie;
import com.MovieBooking.entity.Screen;
import com.MovieBooking.exception.ResourceNotFoundException;
import com.MovieBooking.repository.MovieRepo;
import com.MovieBooking.Service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepo movRepo;

	@Override
	public List<Movie> getAllMovies() {
		return movRepo.findAll();
	}

	@Override
	public Movie getMovieById(long id) {
		return movRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "Id", id));
	}

	@Override
	public List<Screen> getScreenByMovieId(long id) {
		Movie movie = getMovieById(id);
		return new ArrayList<>(movie.getScreen());
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Movie addMovie(Movie movie) {
		return movRepo.save(movie);
	}

	@Override
	public Movie updateMovie(Movie movie, long id) {
		Movie movies = movRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Movie", "Id", id)); 
		movies.setReleaseDate(movie.getReleaseDate());
		movies.setScreen(movie.getScreen());
		movies.setShowTime(movie.getShowTime());
		movies.setTitle(movie.getTitle());
		
		return movRepo.save(movies);
	}

	@Override
	public void deleteMovie(long id) {
		movRepo.deleteById(id);
	}

}
