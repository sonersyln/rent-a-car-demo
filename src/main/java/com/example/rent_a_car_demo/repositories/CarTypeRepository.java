package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository<CarType, Integer> {
}
