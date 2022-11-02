package com.MovieBooking.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class SeatBooked implements Comparable<SeatBooked>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seat_booked_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "seat_id")
	@JsonManagedReference
	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	@JsonManagedReference
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name = "screen_id")
	@JsonManagedReference
	private Screen screen;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public SeatBooked(long id, Seat seat, Booking booking, Screen screen) {
		super();
		this.id = id;
		this.seat = seat;
		this.booking = booking;
		this.screen = screen;
	}

	public SeatBooked() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(booking, id, screen, seat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeatBooked other = (SeatBooked) obj;
		return Objects.equals(booking, other.booking) && id == other.id && Objects.equals(screen, other.screen)
				&& Objects.equals(seat, other.seat);
	}

	@Override
	public int compareTo(SeatBooked o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
