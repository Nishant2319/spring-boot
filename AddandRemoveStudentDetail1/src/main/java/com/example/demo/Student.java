package com.example.demo;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Student {
	
	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	int roll;
	String name;
	@Value("#{18}")
	int age;
	
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
