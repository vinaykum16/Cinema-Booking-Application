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

import com.MovieBooking.entity.Booking;
import com.MovieBooking.Service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookService;
	
	@GetMapping("/bookings")
	public List<Booking> showAllBookings(){
		return bookService.getAllBooking();
	}
	
	@GetMapping("/bookings/{id}")
	public Booking showBookingById(@PathVariable("id") long id) {
		return bookService.getById(id);
	}
	
	@PostMapping("/booking/new")
	public Booking addNewBooking(@RequestBody Booking booking) {
		return bookService.addBooking(booking);
	}
	
	@PutMapping("/bookings/{id}")
	public Booking UpdateBookingById(@RequestBody Booking booking,@PathVariable("id") long id) {
		return bookService.UpdateBooking(booking, id);
	}
	
	@DeleteMapping("/bookings/{id}")
	public void deleteBookingById(@PathVariable("id") long id) {
		bookService.deleteBooking(id);
	}

}
