package com.example.rent_a_car_demo.dtos.requests.updateRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
    private int id;
    private Date rentalStartDate;
    private Date rentalEndDate;
    private Double totalCost;
}
