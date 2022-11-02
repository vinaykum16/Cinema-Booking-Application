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

import com.MovieBooking.entity.Seat;
import com.MovieBooking.Service.SeatService;


@RestController
public class SeatController {
	
	@Autowired
	private SeatService seatService;
	
	@GetMapping("/seats")
	public List<Seat> showAllSeats(){
		return seatService.getAllSeat();
	}
	
	@GetMapping("/seats/{id}")
	public Seat showSeatById(@PathVariable("id") long id) {
		return seatService.getSeatById(id);
	}
	
	@PostMapping("/seat/new")
	public Seat addNewSeat(@RequestBody Seat seat) {
		return seatService.addSeat(seat);
	}

	@PutMapping("/seats/{id}")
	public Seat updateSeatById(@RequestBody Seat seat, @PathVariable("id") long id) {
		return seatService.updateSeat(seat, id);
	}
	
	@DeleteMapping("/seats/{id}")
	public void deleteSeatById(@PathVariable("id") long id) {
		seatService.deleteById(id);
	}
}
