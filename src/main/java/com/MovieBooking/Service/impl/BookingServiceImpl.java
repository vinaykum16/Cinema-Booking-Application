package com.MovieBooking.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.MovieBooking.entity.Booking;
import com.MovieBooking.exception.ResourceNotFoundException;
import com.MovieBooking.repository.BookingRepo;
import com.MovieBooking.Service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepo booRepo;
	
	@Override
	public List<Booking> getAllBooking() {
		return booRepo.findAll();
	}
	
	@Override
	public Booking getById(long id) {
		return booRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking", "Id", id));
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Booking addBooking(Booking booking) {
		return booRepo.save(booking);
	}
	
	@Override
	public Booking UpdateBooking(Booking booking, long id) {
		Booking bookings = booRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Booking", "Id", id));
		bookings.setBookedSeat(booking.getBookedSeat());
		bookings.setBookingTime(booking.getBookingTime());
		bookings.setScreen(booking.getScreen());
		bookings.setUser(booking.getUser());
		
		return booRepo.save(bookings);
	}
	
	@Override
	public void deleteBooking(long id) {
		booRepo.deleteById(id);
	}
}
