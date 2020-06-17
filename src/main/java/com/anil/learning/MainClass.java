package com.anil.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainClass {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringDataService1Application.class, args);
		

	}
	
	@Bean
	public String getStringRes() {
		return "Anil";
	}

}
