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
public class Seat implements Comparable<Seat> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seat_id")
	private long id;
	
	private int seatNumber;
	
	@ManyToOne
	@JoinColumn(name = "auditorium_id")
	@JsonManagedReference
	private Auditorium auditorium;
	
	@OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<SeatBooked> bookedSeats;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
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

	public Seat(long id, int seatNumber, Auditorium auditorium, Set<SeatBooked> bookedSeats) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.auditorium = auditorium;
		this.bookedSeats = bookedSeats;
	}

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(auditorium, bookedSeats, id, seatNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return Objects.equals(auditorium, other.auditorium) && Objects.equals(bookedSeats, other.bookedSeats)
				&& id == other.id && seatNumber == other.seatNumber;
	}

	@Override
	public int compareTo(Seat o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
