package com.blackpool.Model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "userId")
public class UserRating {
	
	private String userId; 
	
	
	private List<MovieRating> moviesrating;
	
	public UserRating() {
		
	}
	
	
	public UserRating(String userId, List<MovieRating> moviesrating) {
		super();
		this.userId = userId;
		this.moviesrating = moviesrating;
	}


	public UserRating(String userId) {
		this.userId=userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<MovieRating> getMoviesrating() {
		return moviesrating;
	}

	public void setMoviesrating(List<MovieRating> moviesrating) {
		this.moviesrating = moviesrating;
	}

	

	
	
}
