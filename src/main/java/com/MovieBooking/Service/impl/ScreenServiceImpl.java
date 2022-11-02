package com.MovieBooking.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.MovieBooking.entity.Screen;
import com.MovieBooking.entity.Seat;
import com.MovieBooking.exception.ResourceNotFoundException;
import com.MovieBooking.repository.ScreenRepo;
import com.MovieBooking.Service.ScreenService;

@Service
public class ScreenServiceImpl implements ScreenService{

	@Autowired
	private ScreenRepo scrRepo;
	
	@Override
	public List<Screen> getAllScreen(){
		return scrRepo.findAll();
	}
	
	@Override
	public Screen getScreenById(long id) {
		return scrRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Screen", "Id", id));
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Screen addScreen(Screen screen) {
		return scrRepo.save(screen);
	}
	
	@Override
	public Screen updateScreen(Screen screen, long id) {
		Screen screens = scrRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Screen", "Id", id));
		screens.setAuditorium(screen.getAuditorium());
		screens.setBookedSeats(screen.getBookedSeats());
		screens.setBooking(screen.getBooking());
		screens.setMovie(screen.getMovie());
		screens.setType(screen.getType());
		
		return scrRepo.save(screens);
	}
	
	@Override
	public List<Seat> getSeatByScreenId(long id){
		Screen screen = getScreenById(id);
		return new ArrayList<>(screen.getAuditorium().getSeats());
	}
	
	@Override
	public void deleteScreen(long id) {
		scrRepo.deleteById(id);
	}
	
}
