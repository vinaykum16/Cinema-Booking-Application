package com.MovieBooking.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class User implements Comparable<User> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	private String userName;
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Booking> booking;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

	public User(long id, String userName, String password, Set<Booking> booking) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.booking = booking;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(booking, id, password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(booking, other.booking) && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
