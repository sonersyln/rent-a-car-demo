package com.example.rent_a_car_demo.dtos.requests.addRequests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private Integer year;
    private String color;
    private Double rentalFee;
    private String licencePlate;
}
