package com.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MovieBooking.entity.Screen;
import com.MovieBooking.entity.Seat;
import com.MovieBooking.exception.HouseFullException;

import lombok.extern.slf4j.Slf4j;

import com.MovieBooking.Service.ScreenService;

@Slf4j
@RestController
public class ScreenController {
	
	@Autowired
	private ScreenService scrService;
	
	@GetMapping("/screens")
	public ResponseEntity<?> showAllScreens(){
		List<Screen> screens = scrService.getAllScreen();
		return ResponseEntity.status(HttpStatus.OK).body(screens);
	}
	
	@GetMapping("/screen/{id}")
	public ResponseEntity<?> showScreenById(@PathVariable("id") long id) {
		Screen screens= scrService.getScreenById(id);
		return ResponseEntity.status(HttpStatus.OK).body(screens);
	}
	
	@GetMapping("/screen/{id}/seats")
	public ResponseEntity<?> showSeatsByScreenId(@PathVariable("id") long id) throws HouseFullException {
		List<Seat> seat = scrService.getSeatByScreenId(id);
		if(seat.size() == 0) {
			throw new HouseFullException();
		}
		return ResponseEntity.status(HttpStatus.OK).body(seat);
	}
	
	@PostMapping("/screen/new")
	public ResponseEntity<?> addNewScreen(@RequestBody Screen screen) {
		Screen screens = scrService.addScreen(screen);
		return ResponseEntity.status(HttpStatus.OK).body(screens);
	}
	
	@PutMapping("/screen/{id}")
	public ResponseEntity<?> updateScreenById(@RequestBody Screen screen,@PathVariable("id") long id) {
		Screen screens = scrService.updateScreen(screen, id);
		return ResponseEntity.status(HttpStatus.OK).body(screens);
	}
	
	@DeleteMapping("/screen/{id}")
	public void deleteScreenById(@PathVariable("id") long id) {
		scrService.deleteScreen(id);
	}

}
