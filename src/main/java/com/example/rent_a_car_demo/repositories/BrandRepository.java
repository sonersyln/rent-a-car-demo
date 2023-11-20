package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
