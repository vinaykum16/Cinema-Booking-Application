package com.MovieBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBooking.entity.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Long> {

}
