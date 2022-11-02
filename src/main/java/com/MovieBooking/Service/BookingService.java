package com.MovieBooking.Service;

import java.util.List;

import com.MovieBooking.entity.Booking;

public interface BookingService {
	
	List<Booking> getAllBooking();
	
	Booking getById(long id);
	
	Booking addBooking(Booking booking);
	
	Booking UpdateBooking(Booking booking, long id);
	
	void deleteBooking(long id);

}
