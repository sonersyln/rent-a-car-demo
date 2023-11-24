package com.example.rent_a_car_demo.dtos.responses.getResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {


    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String phone;

    private String gender;

    private Date birthDate;
}
