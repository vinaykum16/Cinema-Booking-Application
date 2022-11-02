package com.MovieBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBooking.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

}
