package com.example.rent_a_car_demo.dtos.responses.getResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalResponse {
    private Date rentalStartDate;
    private Date rentalEndDate;
}
