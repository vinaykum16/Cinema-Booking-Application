package com.MovieBooking.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.MovieBooking.entity.User;
import com.MovieBooking.exception.ResourceNotFoundException;
import com.MovieBooking.repository.UserRepo;
import com.MovieBooking.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	@Override
	public User getUserById(long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		return user;
		
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	@Override
	public User updateUser(User user, long id) {
		User users = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		users.setUserName(user.getUserName());
		users.setPassword(user.getPassword());
		users.setBooking(user.getBooking());
		
		return userRepo.save(users);
	}
	
	@Override
	public void deleteUserById(long id) {
		userRepo.deleteById(id);
	}
	
}
