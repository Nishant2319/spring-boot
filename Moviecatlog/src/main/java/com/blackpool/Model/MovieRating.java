package com.blackpool.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "movieId")
public class MovieRating {
	private String movieId;
	private int rating;
	private List<UserRating> userRating;
	
	
	public MovieRating(String movieId, int rating, List<UserRating> userRating) {
		this.movieId = movieId;
		this.rating = rating;
		this.userRating = userRating;
	}


	public MovieRating() {
	}
	
	
	public MovieRating(String movieId, int rating) {
		super();
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
