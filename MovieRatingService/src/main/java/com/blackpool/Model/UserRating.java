package com.blackpool.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "userId")
@Entity
public class UserRating {
	
	@Id
	private String userId; 
	
	
	@ManyToMany
//	@JsonManagedReference
	private List<MovieRating> moviesrating;

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
