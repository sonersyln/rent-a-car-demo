package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.User;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    List<User> findByGender (String gender);

    @Query("SELECT u FROM User u WHERE u.birthDate > :birthDate")
    List<GetUserResponse> findByBirthDateAfter(Date birthDate);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    List<GetUserResponse> findByEmailAndPassword(String email, String password);

}
