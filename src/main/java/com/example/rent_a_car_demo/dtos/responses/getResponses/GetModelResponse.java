package com.example.rent_a_car_demo.dtos.responses.getResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelResponse {

    private String name;

    private String fuelType;

    private String enginePower;

    private String brandName;
}
