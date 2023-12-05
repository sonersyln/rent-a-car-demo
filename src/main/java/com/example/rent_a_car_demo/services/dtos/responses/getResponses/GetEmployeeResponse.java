package com.example.rent_a_car_demo.services.dtos.responses.getResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String role;
    private String phone;
    private String gender;
    private Date birthDate;
    private GetRentalResponse rental;
}
