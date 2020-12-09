package com.blackpool.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	private String moveId;
	private String movieName;
	private String movieDescription;
	
	public Movie() {
	}

	public Movie(String moveId, String movieName, String movieDescription) {
		super();
		this.moveId = moveId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
	}

	public String getMoveId() {
		return moveId;
	}

	public void setMoveId(String moveId) {
		this.moveId = moveId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	
	
}
