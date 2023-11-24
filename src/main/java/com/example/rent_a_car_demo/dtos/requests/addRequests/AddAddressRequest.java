package com.example.rent_a_car_demo.dtos.requests.addRequests;

import com.example.rent_a_car_demo.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {

    private String address;

    private String country;

    private String region;

    private String city;

    private String zipCode;

    private User user;
}
