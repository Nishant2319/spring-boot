package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	Repository repo;
	
	public void add(Student s) {
		repo.save(s);
	}
	
	public List<Student> getAll(){
		return repo.findAll();
	}
	
	public Student getById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Student> getByAge(int a){
		return repo.findByAge(a);
	}
	
	public List<Student> getByName(String name){
		return repo.findByName(name);
	}
	
	public void update(Student s) {
		repo.save(s);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public void deleteAll() {
		repo.deleteAll();
	}
	
	public void deleteName(String n) {
		repo.deleteByName(n);
	}
}
