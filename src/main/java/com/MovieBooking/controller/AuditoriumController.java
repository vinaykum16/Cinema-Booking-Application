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

import com.MovieBooking.entity.Auditorium;
import com.MovieBooking.Service.AuditoriumService;


@RestController
public class AuditoriumController {
	
	@Autowired
	private AuditoriumService audiService;
	
	@GetMapping("/auditoriums")
	public List<Auditorium> showAllAuditorium(){
		return audiService.getAllAuditoriums();
	}
	
	@GetMapping("/auditorium/{id}")
	public Auditorium showAuditoriumById(@PathVariable("id") long id){
		return audiService.getById(id);
	}
	
	@PostMapping("/auditorium/new")
	public Auditorium addNewAuditorium(@RequestBody Auditorium audi) {
		return audiService.addAuditorium(audi);
	} 
	
	@PutMapping("/auditorium/{id}")
	public Auditorium updateAuditoriumById(@RequestBody Auditorium audi, @PathVariable("id") long id) {
		return audiService.updateAuditorium(audi, id);
	} 
	
	@DeleteMapping("/auditorium/{id}")
	public void deleteAuditoriumById(@PathVariable("id") long id) {
		audiService.deleteById(id);
	}

}
