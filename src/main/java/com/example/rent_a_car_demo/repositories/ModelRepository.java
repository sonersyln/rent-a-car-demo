package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
