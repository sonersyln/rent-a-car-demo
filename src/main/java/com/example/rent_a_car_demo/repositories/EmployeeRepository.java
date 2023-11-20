package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
