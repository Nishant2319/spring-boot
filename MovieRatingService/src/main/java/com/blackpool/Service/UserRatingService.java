package com.blackpool.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackpool.Model.MovieRating;
import com.blackpool.Model.UserRating;
import com.blackpool.Repostiory.UserRatingRepository;

@Service
public class UserRatingService {
	
	@Autowired
	private UserRatingRepository userRatingRepository;
	
	public Optional<UserRating> getUser(String id){
		return userRatingRepository.findById(id);
	}
	
	public void updateUserRating(UserRating u) {
		userRatingRepository.save(u);
	}
	
	public void deleteUserRating(String id) {
		userRatingRepository.deleteById(id);
	}
}
