package com.example.rent_a_car_demo.dtos.requests.updateRequests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private int id;
    private Integer year;
    private String color;
    private Double rentalFee;
    private String licencePlate;
}
