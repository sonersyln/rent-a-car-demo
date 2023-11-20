package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
