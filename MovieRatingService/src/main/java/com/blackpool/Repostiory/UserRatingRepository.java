package com.blackpool.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackpool.Model.UserRating;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating,String>{

}
