package com.blackpool.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackpool.Model.MovieRating;

@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating,String>{

}
