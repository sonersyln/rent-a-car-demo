package com.example.rent_a_car_demo.services.dtos.requests.addRequests;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {
    @NotNull(message = "Rental start date is required")
    @Future(message = "Rental start date must be in the future")
    private Date rentalStartDate;

    @NotNull(message = "Rental end date is required")
    @Future(message = "Rental end date must be in the future")
    private Date rentalEndDate;

    @Positive(message = "Total cost must be a positive value")
    private double totalCost;

    @Positive(message = "carID must be a positive value")
    private int carId;
    @Positive(message = "userID must be a positive value")
    private int userId;
    @Positive(message = "employeeID must be a positive value")
    private int employeeId;

}
