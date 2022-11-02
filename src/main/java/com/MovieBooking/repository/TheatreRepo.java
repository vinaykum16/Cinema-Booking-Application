package com.MovieBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBooking.entity.Theatre;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Long> {

}
