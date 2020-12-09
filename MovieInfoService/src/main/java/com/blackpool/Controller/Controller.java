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

import com.blackpool.Model.Movie;
import com.blackpool.Service.MovieService;

@RestController
@RequestMapping("/movie")
public class Controller {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/get/{movieId}")
	public Optional<Movie> getMovieAllDetails(@PathVariable String movieId) {
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return movieService.get(movieId);		 
	}
	
	@GetMapping("/getAll")
	public List<Movie> getMovieDetails() {
		return movieService.getAll();
	}
	
	@GetMapping("/delete/{movieId}")
	public void delete(@PathVariable String movieId) {
		movieService.delete(movieId);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Movie m) {
		movieService.update(m);
	}
}
