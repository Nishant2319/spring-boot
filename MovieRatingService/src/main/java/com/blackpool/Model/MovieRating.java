package com.blackpool.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "movieId")
@Entity
public class MovieRating {
	
	@Id
	private String movieId;
	private int rating;
	@ManyToMany(mappedBy = "moviesrating")
//	@JsonBackReference
	private List<UserRating> userRating;
	
	public MovieRating() {
		
	}
	public MovieRating(String movieId, int rating) {
		this.movieId = movieId;
		this.rating = rating;
	}


	public String getMovieId() {
		return movieId;
	}


	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public List<UserRating> getUserRating() {
		return userRating;
	}


	public void setUserRating(List<UserRating> userRating) {
		this.userRating = userRating;
	}
	
	
	
}
