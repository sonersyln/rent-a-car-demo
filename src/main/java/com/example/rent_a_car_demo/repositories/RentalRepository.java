package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
