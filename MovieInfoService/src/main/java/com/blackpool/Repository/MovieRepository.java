package com.blackpool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackpool.Model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String>{
	
}
