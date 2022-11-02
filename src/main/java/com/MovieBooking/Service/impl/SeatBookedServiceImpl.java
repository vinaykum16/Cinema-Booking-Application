package com.MovieBooking.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.MovieBooking.entity.SeatBooked;
import com.MovieBooking.exception.ResourceNotFoundException;
import com.MovieBooking.repository.SeatBookedRepo;
import com.MovieBooking.Service.SeatBookedService;

@Service
public class SeatBookedServiceImpl implements SeatBookedService{

	@Autowired
	private SeatBookedRepo sbRepo;
	
	@Override
	public List<SeatBooked> getAllSeatBooked(){
		return sbRepo.findAll();
	}
	
	@Override
	public SeatBooked getSeatBookedById(long id) {
		return sbRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("SetaBooked", "Id", id));
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public SeatBooked addSeatBooked(SeatBooked seatBooked) {
		return sbRepo.save(seatBooked);
	}
	
	@Override
	public SeatBooked updateSeatBooked(SeatBooked updateSB, long id) {
		SeatBooked seatBook = sbRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("SetaBooked", "Id", id));
		seatBook.setBooking(updateSB.getBooking());
		seatBook.setScreen(updateSB.getScreen());
		seatBook.setSeat(updateSB.getSeat());
		
		return sbRepo.save(seatBook);
	}
	
	@Override
	public void deleteSeatBookedById(long id) {
		sbRepo.deleteById(id);
	}
	
}
