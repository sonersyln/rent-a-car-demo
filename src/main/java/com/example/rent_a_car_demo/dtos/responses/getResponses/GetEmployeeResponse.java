package com.example.rent_a_car_demo.dtos.responses.getResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
}
