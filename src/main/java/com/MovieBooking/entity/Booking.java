package com.MovieBooking.entity;

import java.time.LocalTime;
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
public class Booking implements Comparable<Booking> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private long id;
	
	private LocalTime bookingTime;
	
	private boolean isBooked;
	
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name = "screen_id")
	@JsonManagedReference
	private Screen screen;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;
	
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<SeatBooked> bookedSeat;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<SeatBooked> getBookedSeat() {
		return bookedSeat;
	}

	public void setBookedSeat(Set<SeatBooked> bookedSeat) {
		this.bookedSeat = bookedSeat;
	}

	public Booking(long id, LocalTime bookingTime, boolean isBooked, boolean isActive, Screen screen, User user,
			Set<SeatBooked> bookedSeat) {
		super();
		this.id = id;
		this.bookingTime = bookingTime;
		this.isBooked = isBooked;
		this.isActive = isActive;
		this.screen = screen;
		this.user = user;
		this.bookedSeat = bookedSeat;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookedSeat, bookingTime, id, isActive, isBooked, screen, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookedSeat, other.bookedSeat) && Objects.equals(bookingTime, other.bookingTime)
				&& id == other.id && isActive == other.isActive && isBooked == other.isBooked
				&& Objects.equals(screen, other.screen) && Objects.equals(user, other.user);
	}

	@Override
	public int compareTo(Booking o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
