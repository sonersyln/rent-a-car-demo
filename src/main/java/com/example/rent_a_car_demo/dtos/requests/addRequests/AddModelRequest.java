package com.example.rent_a_car_demo.dtos.requests.addRequests;

import com.example.rent_a_car_demo.models.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {

    private String name;

    private String fuelType;

    private String enginePower;

    private Brand brand;


}
