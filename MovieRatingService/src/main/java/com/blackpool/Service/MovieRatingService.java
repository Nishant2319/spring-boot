package com.blackpool.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackpool.Model.MovieRating;
import com.blackpool.Repostiory.MovieRatingRepository;

@Service
public class MovieRatingService {
	
	@Autowired
	private MovieRatingRepository movieRatingRepository;
	
	public List<MovieRating> getAll() {
		return movieRatingRepository.findAll();
	}
	public Optional<MovieRating> getRating(String id) {
		return movieRatingRepository.findById(id);
	}
	
	public void updateRating(MovieRating m) {
		movieRatingRepository.save(m);
	}
	
	public void deleteRating(String id) {
		movieRatingRepository.deleteById(id);
	}
}
