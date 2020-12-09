package com.blackpool;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.blackpool.Model.Movie;
import com.blackpool.Model.MovieRating;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MoviecatlogApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoviecatlogApplication.class, args);
	}

}
