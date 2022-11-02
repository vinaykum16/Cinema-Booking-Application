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

import com.MovieBooking.entity.User;

import lombok.extern.slf4j.Slf4j;

import com.MovieBooking.Service.UserService;

@Slf4j
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<?> showAllUser(){
		List<User> users = userService.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> showUserById(@PathVariable("id") long id) {
		User users = userService.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@PostMapping("/user/new")
	public ResponseEntity<?> addNewUser(@RequestBody User user) {
		User users = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUserById(@RequestBody User user,@PathVariable("id") long id) {
		User users = userService.updateUser(user, id);
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		userService.deleteUserById(id);
	}

}
