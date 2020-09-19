package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Autowired
	Service ser;
	
	
	
	@PostMapping("/stu/add")
	public void add(@RequestBody Student s) {
		ser.add(s);
	}
	
	@GetMapping("/stu/fetchall")
	public List<Student> getAll() {
		return ser.getAll();
	}
	
	@GetMapping("/stu/fetchById/{id}")
	public Student getId(@PathVariable int id) {
		return ser.getById(id);
	}
	
	@GetMapping("/stu/fetchByName/{name}")
	public List<Student> getName(@PathVariable String name){
		return ser.getByName(name);
	}
	
	@GetMapping("/stu/fetchByAge/{age}")
	public List<Student> getAge(@PathVariable int age){
		return ser.getByAge(age);
	}
	
	@PostMapping("/stu/update")
	public void update(@RequestBody Student s) {
		ser.update(s);
	}
	
	@GetMapping("/stu/deleteById/{id}")
	public void deleteId(@PathVariable int id) {
		ser.delete(id);
	}
	
	@GetMapping("/stu/deleteByName/{name}")
	public void deleteName(@PathVariable String name) {
		ser.deleteName(name);
	}
	
	@GetMapping("/stu/delete")
	public void deleteId() {
		ser.deleteAll();
	}
	
}
