package com.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MovieBooking.entity.Theatre;
import com.MovieBooking.Service.TheatreService;

@RestController
public class TheatreController {
	
	@Autowired
	private TheatreService theService;
	
	@GetMapping("/theatres")
	public List<Theatre> showAllTheatres(){
		return theService.getAllTheatre();
	}
	
	@GetMapping("/theatres/{id}")
	public Theatre showTheatreById(@PathVariable("id") long id) {
		return theService.getTheatreById(id);
	}
	
	@PostMapping("/newtheatre")
	public Theatre addNewTheatre(@RequestBody Theatre theatre) {
		return theService.addTheatre(theatre);
	}
	
	@PutMapping("/theatres/{id}")
	public Theatre updateTheatreById(@RequestBody Theatre theatre,@PathVariable("id") long id) {
		return theService.updateTheatre(theatre, id);
	}
	
	@DeleteMapping("/theatres/{id}")
	public void deleteTheatre(@PathVariable("id") long id) {
		theService.deleteTheatreById(id);
	}

}
