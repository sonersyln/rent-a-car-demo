 package com.example.rent_a_car_demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

 @SpringBootApplication

public class RentACarDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarDemoApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
