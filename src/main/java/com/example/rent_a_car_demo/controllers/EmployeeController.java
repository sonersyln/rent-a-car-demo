package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.models.Employee;
import com.example.rent_a_car_demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/getall")
    public List<Employee> getallEmployees(){return employeeService.getAllEmployees();}
    @GetMapping("/get")
    public Employee getEmployeeById(@RequestParam(value = "id") Integer id){return employeeService.getEmployeeById(id);}
    @PostMapping("/add")
    public void saveEmployee(@RequestBody Employee employee){employeeService.saveEmployee(employee);}
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
        employee.setId(id);
        employeeService.saveEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id){employeeService.deleteEmployee(id);}
}
