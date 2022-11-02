package com.MovieBooking.Service;

import java.util.List;

import com.MovieBooking.entity.Seat;

public interface SeatService {
	
	List<Seat> getAllSeat();
	
	Seat getSeatById(long id);
	
	Seat addSeat(Seat seat);
	
	Seat updateSeat(Seat seat, long id);
	
	void deleteById(long id);

}
