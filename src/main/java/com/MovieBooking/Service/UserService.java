package com.MovieBooking.Service;

import java.util.List;

import com.MovieBooking.entity.User;

public interface UserService {
	
	List<User> getAllUser();
	
	User getUserById(long id);
	
	User addUser(User user);
	
	User updateUser(User user, long id);
	
	void deleteUserById(long id);

}
