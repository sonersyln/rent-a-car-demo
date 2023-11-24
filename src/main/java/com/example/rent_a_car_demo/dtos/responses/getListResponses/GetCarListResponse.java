package com.example.rent_a_car_demo.dtos.responses.getListResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private Integer year;
    private String color;
    private Double rentalFee;
    private String licencePlate;
}
