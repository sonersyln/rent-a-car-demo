package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddEmployeeRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateEmployeeRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetEmployeeListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetEmployeeResponse;
import com.example.rent_a_car_demo.services.abstracts.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/Employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getall")
    public List<GetEmployeeListResponse> getEmployeeList(){
        return this.employeeService.getEmployeeList();}
    @GetMapping("/{id}")
    public GetEmployeeResponse getEmployeeById(@PathVariable int id){
        return this.employeeService.getEmployeeById(id);}
    @PostMapping("/create")
    public String createEmployee(@RequestBody AddEmployeeRequest addEmployeeRequest){
        return this.employeeService.createEmploye(addEmployeeRequest);
    }
    @PutMapping("/update")
    public String updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) throws Exception {
        return this.employeeService.updateEmployee(updateEmployeeRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) throws Exception {
       return this.employeeService.deleteByEmployee(id);
    }

    @GetMapping("/byRole")
    public List<GetEmployeeResponse> getByRole(@RequestParam String role) {
        return employeeService.findByRole(role);
    }

    @GetMapping("birthDateBefore")
    public List<GetEmployeeResponse> getByBirthDateBefore(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate targetDate) {
        Date targetDateAsDate = java.sql.Date.valueOf(targetDate);
        return employeeService.findByBirthDateBefore(targetDateAsDate);
    }

    @GetMapping("/lastNameStartingWith")
    public List<GetEmployeeResponse> getByLastNameStartingWith(@RequestParam String lastName){
        return employeeService.findByLastNameStartingWith(lastName);
    }

    @GetMapping("/byGenderAndRole")
    public List<GetEmployeeResponse> getByGenderAndRole(@RequestParam String gender, @PathVariable String role ){
        return employeeService.findByGenderAndRole(gender, role);
    }












}
