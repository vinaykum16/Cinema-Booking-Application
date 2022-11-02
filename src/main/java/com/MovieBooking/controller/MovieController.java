package com.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MovieBooking.entity.Movie;
import com.MovieBooking.entity.Screen;

import lombok.extern.slf4j.Slf4j;

import com.MovieBooking.Service.MovieService;

@Slf4j
@RestController
public class MovieController {

	@Autowired
	private MovieService movService;
	
	@GetMapping("/movies")
	public ResponseEntity<?> showAllMovies(){
		List<Movie> movie = movService.getAllMovies();
		return ResponseEntity.status(HttpStatus.OK).body(movie);
	}
	
	@GetMapping("/movies/{id}")
	public ResponseEntity<?> showMovieById(@PathVariable("id") long id) {
		Movie movie = movService.getMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).body(movie);
	}
	
	@GetMapping("/movies/{id}/screens")
	public ResponseEntity<?> showScreensByMovieId(@PathVariable("id") long id){
		List<Screen> screen = movService.getScreenByMovieId(id);
		return ResponseEntity.status(HttpStatus.OK).body(screen);
	}
	
	@PostMapping("/movie/new")
	public ResponseEntity<?> addNewMovie(@RequestBody Movie movie) {
		Movie movies = movService.addMovie(movie);
		return ResponseEntity.status(HttpStatus.OK).body(movies);
	}
	
	@PutMapping("/movie/{id}")
	public ResponseEntity<?> updateMovieById(@RequestBody Movie movie, @PathVariable("id") long id) {
		Movie movies =  movService.updateMovie(movie, id);
		return ResponseEntity.status(HttpStatus.OK).body(movies);
	}

	@DeleteMapping("/movie/{id}")
	public void deleteMovieById(@PathVariable("id") long id) {
		movService.deleteMovie(id);
	}
	
	
}
