package com.MovieBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBooking.entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long>{

}
