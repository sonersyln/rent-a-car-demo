package com.example.rent_a_car_demo.services;

import com.example.rent_a_car_demo.models.Employee;
import com.example.rent_a_car_demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public void saveEmployee(Employee employee){employeeRepository.save(employee);}

    public void deleteEmployee(Integer id){employeeRepository.deleteById(id);}
}