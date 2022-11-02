package com.MovieBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBooking.entity.SeatBooked;

@Repository
public interface SeatBookedRepo extends JpaRepository<SeatBooked, Long> {

}
