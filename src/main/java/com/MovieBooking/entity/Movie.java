package com.MovieBooking.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Movie implements Comparable<Movie>{
	
	@Id
	@Column(name="movie_id")
	private long id;
	private String title;
	private LocalDate releaseDate;
	private LocalTime showTime;
	
	@OneToMany(mappedBy = "movie", cascade=CascadeType.ALL)
	@JsonBackReference
	private Set<Screen> screen;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public LocalTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}

	public Set<Screen> getScreen() {
		return screen;
	}

	public void setScreen(Set<Screen> screen) {
		this.screen = screen;
	}

	public Movie(long id, String title, LocalDate releaseDate, LocalTime showTime, Set<Screen> screen) {
		super();
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.showTime = showTime;
		this.screen = screen;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, releaseDate, screen, showTime, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return id == other.id && Objects.equals(releaseDate, other.releaseDate) && Objects.equals(screen, other.screen)
				&& Objects.equals(showTime, other.showTime) && Objects.equals(title, other.title);
	}

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
