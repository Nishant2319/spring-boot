package com.blackpool.Controller;

import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackpool.Model.UserRating;
import com.blackpool.Service.UserRatingService;

@RestController
@RequestMapping("/userrating")
public class UserController {
	
	@Autowired
	private UserRatingService userRatingService;

	@GetMapping("/get/{userId}")
	public Optional<UserRating> getRating(@PathVariable String userId) {
		return userRatingService.getUser(userId);
	}
	
	@GetMapping("/delete/{userId}")
	public void deleteRating(@PathVariable String userId) {
		userRatingService.deleteUserRating(userId);
	}
	
	@PostMapping(value="/update")
	public void updateRating(@RequestBody UserRating userRating) {
		userRatingService.updateUserRating(userRating);
	}
}



