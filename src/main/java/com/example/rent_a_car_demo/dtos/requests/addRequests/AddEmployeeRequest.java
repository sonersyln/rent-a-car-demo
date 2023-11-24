package com.example.rent_a_car_demo.dtos.requests.addRequests;

import com.example.rent_a_car_demo.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest  {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String role;
    private String phone;
    private String gender;
    private Date birthDate;
}
