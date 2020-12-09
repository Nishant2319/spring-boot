package com.blackpool.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackpool.Model.MovieRating;
import com.blackpool.Service.MovieRatingService;


@RestController
@RequestMapping("/movierating")
public class MovieController {

	@Autowired
	private MovieRatingService moviesRatingService;
	
	@GetMapping("/getAll")
	public List<MovieRating> getAll(){
		return moviesRatingService.getAll();
	}
	
	@GetMapping("/get/{movieId}")
	public Optional<MovieRating> get(@PathVariable String movieId) {
		return moviesRatingService.getRating(movieId);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody MovieRating m) {
		moviesRatingService.updateRating(m);
	}
	
	@GetMapping("/delete/{movieId}")
	public void delete(@PathVariable String movieId) {
		moviesRatingService.deleteRating(movieId);
	}
}
