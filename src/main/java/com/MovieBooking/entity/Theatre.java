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
public class Theatre implements Comparable<Theatre>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "theatre_id")
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Auditorium> auditorium;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Auditorium> getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Set<Auditorium> auditorium) {
		this.auditorium = auditorium;
	}

	public Theatre(long id, String name, Set<Auditorium> auditorium) {
		super();
		this.id = id;
		this.name = name;
		this.auditorium = auditorium;
	}

	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(auditorium, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		return Objects.equals(auditorium, other.auditorium) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Theatre o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
