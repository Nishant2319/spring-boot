package com.blackpool.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.blackpool.Model.CatlogItem;
import com.blackpool.Model.Movie;
import com.blackpool.Model.MovieRating;
import com.blackpool.Model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class Controller {


	@Autowired
	private RestTemplate resttamplate;

	@GetMapping("/catalog/{userId}")
	@HystrixCommand(fallbackMethod = "getMovieFallBack")
	public List<CatlogItem> getMovie(@PathVariable String userId) {

		UserRating rating = resttamplate.getForObject("http://movie-rating-service/userrating/get/" + userId, UserRating.class);
		System.out.println(rating.getUserId());
		for(MovieRating i : rating.getMoviesrating()) {
			System.out.println(i.getMovieId()+"    "+i.getRating());
		}
		return rating.getMoviesrating().stream().map(r -> {
			Movie mov = resttamplate.getForObject("http://movie-info-service/movie/get/" + r.getMovieId(), Movie.class);
			System.out.println(mov.getMovieDescription());
			return new CatlogItem(mov.getMovieName(), mov.getMovieDescription(), r.getRating());
		}).collect(Collectors.toList());

	}


	public List<CatlogItem> getMovieFallBack(@PathVariable String userId) {

		return Arrays.asList(new CatlogItem("ek tha london","bekar", 4),
				new CatlogItem("the tiger","superb ", 4),
				new CatlogItem("faster","not too much", 5),
				new CatlogItem("kingsman","good", 6)
				);
	}
}
