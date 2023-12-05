package com.example.rent_a_car_demo.services.dtos.responses.getResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetCarResponse {
    private Integer year;
    private String color;
    private Double rentalFee;
    private String licencePlate;
    private GetCarTypeResponse carType;

}
