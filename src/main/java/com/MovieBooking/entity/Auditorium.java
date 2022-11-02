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
public class Auditorium implements Comparable<Auditorium>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="auditorium_id")
	private long id;
	
	private int seatCount;
	
	@ManyToOne
	@JoinColumn(name ="theatre_id")
	@JsonManagedReference
	private Theatre theatre;
	
	@OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Seat> seats;
	
	@OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Screen> screen;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public Set<Screen> getScreen() {
		return screen;
	}

	public void setScreen(Set<Screen> screen) {
		this.screen = screen;
	}

	public Auditorium(long id, int seatCount, Theatre theatre, Set<Seat> seats, Set<Screen> screen) {
		super();
		this.id = id;
		this.seatCount = seatCount;
		this.theatre = theatre;
		this.seats = seats;
		this.screen = screen;
	}

	public Auditorium() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, screen, seatCount, seats, theatre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditorium other = (Auditorium) obj;
		return id == other.id && Objects.equals(screen, other.screen) && seatCount == other.seatCount
				&& Objects.equals(seats, other.seats) && Objects.equals(theatre, other.theatre);
	}

	@Override
	public int compareTo(Auditorium o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
}
