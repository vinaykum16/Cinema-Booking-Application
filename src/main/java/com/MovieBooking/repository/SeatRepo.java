package com.MovieBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBooking.entity.Seat;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Long> {

}
