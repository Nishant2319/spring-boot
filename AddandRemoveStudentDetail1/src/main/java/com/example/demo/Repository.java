package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Student,Integer> {
	List<Student> findByAge(int a);
	
	List<Student> findByName(String n);
	
	
	default void deleteByName(String n){
		
		this.findAll().stream().filter(i->i.name.equals(n)).forEach(i->this.deleteById(i.roll));
	}
}
