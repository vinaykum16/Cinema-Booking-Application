package com.MovieBooking.Service;

import java.util.List;

import com.MovieBooking.entity.Screen;
import com.MovieBooking.entity.Seat;

public interface ScreenService {
	
	 List<Screen> getAllScreen();
	 
	 Screen getScreenById(long id);
	 
	 Screen addScreen(Screen screen);
	 
	 Screen updateScreen(Screen screen, long id);
	 
	 List<Seat> getSeatByScreenId(long id);
	 
	 void deleteScreen(long id);

}
