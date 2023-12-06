package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.Employee;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetEmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //role göre bulma
    @Query("SELECT new com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetEmployeeResponse" +
            "(e.firstName,e.lastName,e.username,e.email,e.role,e.phone,e.gender,e.birthDate)" +
            " FROM Employee e Where e.role = :role")
    List<GetEmployeeResponse> findByRole(String role);

    //doğum gününden önce
    @Query("SELECT new com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetEmployeeResponse" +
            "(e.firstName,e.lastName,e.username,e.email,e.role,e.phone,e.gender,e.birthDate)" +
            "FROM Employee e WHERE e.birthDate < :targetDate")
    List<GetEmployeeResponse> findByBirthDateBefore(Date targetDate);

    //Soy adı .. ile başlayan
    @Query("SELECT new com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetEmployeeResponse" +
            "(e.firstName,e.lastName,e.username,e.email,e.role,e.phone,e.gender,e.birthDate)" +
            "FROM Employee e WHERE LOWER(e.lastName) LIKE :lastName%")
    List<GetEmployeeResponse> findByLastNameStartingWith(String lastName);
    //cinsiyete ve role göre bulma
    @Query("SELECT new com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetEmployeeResponse" +
            "(e.firstName,e.lastName,e.username,e.email,e.role,e.phone,e.gender,e.birthDate)" +
            "FROM Employee e WHERE e.gender = :gender AND e.role = :role")
    List<GetEmployeeResponse> findByGenderAndRole(String gender, String role);


}
