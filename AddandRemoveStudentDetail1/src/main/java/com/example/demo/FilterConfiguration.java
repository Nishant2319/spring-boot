package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
	@Bean
	public FilterRegistrationBean<MyFilter> register(){
		FilterRegistrationBean<MyFilter> reg=new FilterRegistrationBean<>();
		
		reg.setFilter(new MyFilter());
		reg.addUrlPatterns("/home","/add*","/fetch*","/viewStudent.jsp");
		
		return reg;
	}
}
