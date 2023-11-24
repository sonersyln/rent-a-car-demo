package com.example.rent_a_car_demo.dtos.responses.getListResponses;

import com.example.rent_a_car_demo.models.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelListResponse {


    private String name;

    private String fuelType;

    private String enginePower;

    private String brandName;
}
