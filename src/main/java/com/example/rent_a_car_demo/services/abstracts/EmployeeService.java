package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddEmployeeRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateEmployeeRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetEmployeeListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<GetEmployeeListResponse> getEmployeeList();
    GetEmployeeResponse getEmployeeById(Integer id);
    String createEmploye (AddEmployeeRequest addEmployeeRequest);
    String updateEmployee(UpdateEmployeeRequest updateEmployeeRequest);
    String deleteByEmployee(int id) throws Exception;
}
