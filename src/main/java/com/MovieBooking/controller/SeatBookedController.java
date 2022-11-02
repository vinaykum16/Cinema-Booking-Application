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

import com.MovieBooking.entity.SeatBooked;
import com.MovieBooking.Service.SeatBookedService;

@RestController
public class SeatBookedController {
	
	@Autowired
	private SeatBookedService sbService;
	
	@GetMapping("/seatbooked")
	public List<SeatBooked> showAllSeatBooked(){
		return sbService.getAllSeatBooked();
	}
	
	@GetMapping("/seatbooked/{id}")
	public SeatBooked showSeatBookedById(@PathVariable("id") long id) {
		return sbService.getSeatBookedById(id);
	}
	
	@PostMapping("/seatbooked/new")
	public SeatBooked AddNewSeatBooked(@RequestBody SeatBooked seatBooked) {
		return sbService.addSeatBooked(seatBooked);
	}
	
	@PutMapping("/seatbooked/{id}")
	public SeatBooked updateSeatBookedById(@RequestBody SeatBooked updateSB, @PathVariable("id") long id) {
		return sbService.updateSeatBooked(updateSB, id);
	}

	@DeleteMapping("/seatbooked/{id}")
	public void deleteSeatBooked(@PathVariable("id") long id) {
		sbService.deleteSeatBookedById(id);
	}
}
