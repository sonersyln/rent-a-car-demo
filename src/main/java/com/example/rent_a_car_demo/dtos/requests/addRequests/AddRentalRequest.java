package com.example.rent_a_car_demo.dtos.requests.addRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {
    private Date rentalStartDate;
    private Date rentalEndDate;
    private double totalCost;

}
