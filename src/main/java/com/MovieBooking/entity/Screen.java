package com.MovieBooking.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Screen implements Comparable<Screen> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="screen_id")
	private long id;
	
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	@JsonManagedReference
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "auditorium_id")
	@JsonManagedReference
	private Auditorium auditorium;
	
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<SeatBooked> bookedSeats;
	
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Booking> booking;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public Set<SeatBooked> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Set<SeatBooked> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

	public Screen(long id, String type, Movie movie, Auditorium auditorium, Set<SeatBooked> bookedSeats,
			Set<Booking> booking) {
		super();
		this.id = id;
		this.type = type;
		this.movie = movie;
		this.auditorium = auditorium;
		this.bookedSeats = bookedSeats;
		this.booking = booking;
	}

	public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(auditorium, bookedSeats, booking, id, movie, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		return Objects.equals(auditorium, other.auditorium) && Objects.equals(bookedSeats, other.bookedSeats)
				&& Objects.equals(booking, other.booking) && id == other.id && Objects.equals(movie, other.movie)
				&& Objects.equals(type, other.type);
	}

	@Override
	public int compareTo(Screen o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
