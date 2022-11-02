package com.MovieBooking.Service;

import java.util.List;

import com.MovieBooking.entity.SeatBooked;

public interface SeatBookedService {
	
	List<SeatBooked> getAllSeatBooked();
	
	SeatBooked getSeatBookedById(long id);
	
	SeatBooked addSeatBooked(SeatBooked seatBooked);
	
	SeatBooked updateSeatBooked(SeatBooked updateSB, long id);
	
	void deleteSeatBookedById(long id);

}
