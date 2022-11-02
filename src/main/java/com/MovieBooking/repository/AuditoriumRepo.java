package com.MovieBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBooking.entity.Auditorium;

@Repository
public interface AuditoriumRepo extends JpaRepository<Auditorium, Long>{

}
