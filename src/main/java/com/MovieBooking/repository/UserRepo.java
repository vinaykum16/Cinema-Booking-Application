package com.MovieBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBooking.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
