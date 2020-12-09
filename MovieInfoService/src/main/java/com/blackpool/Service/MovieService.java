package com.blackpool.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackpool.Model.Movie;
import com.blackpool.Repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public Optional<Movie> get(String movieId) {
		return movieRepository.findById(movieId);
	}
	
	public List<Movie> getAll(){
		return movieRepository.findAll();
	}
	
	public void update(Movie m) {
		 movieRepository.save(m);
	}
	
	public void delete(String movieId) {
		movieRepository.deleteById(movieId);
	}
}
