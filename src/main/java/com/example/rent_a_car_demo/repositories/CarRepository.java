package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
