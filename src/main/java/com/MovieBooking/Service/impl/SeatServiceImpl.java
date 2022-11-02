package com.MovieBooking.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.MovieBooking.entity.Seat;
import com.MovieBooking.exception.ResourceNotFoundException;
import com.MovieBooking.repository.SeatRepo;
import com.MovieBooking.Service.SeatService;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatRepo seatRepo;
	
	@Override
	public List<Seat> getAllSeat(){
		return seatRepo.findAll();
	}
	
	@Override
	public Seat getSeatById(long id) {
		return seatRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Seat", "Id", id));
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Seat addSeat(Seat seat) {
		return seatRepo.save(seat);
	}
	
	@Override
	public Seat updateSeat(Seat seat, long id) {
		Seat seats = seatRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Seat", "Id", id));
		seats.setAuditorium(seat.getAuditorium());
		seats.setBookedSeats(seat.getBookedSeats());
		seats.setSeatNumber(seat.getSeatNumber());
		
		return seatRepo.save(seats);
	}
	
	@Override
	public void deleteById(long id) {
		seatRepo.deleteById(id);
	}

}
