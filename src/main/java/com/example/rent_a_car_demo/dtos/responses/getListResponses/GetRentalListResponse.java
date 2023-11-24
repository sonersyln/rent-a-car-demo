package com.example.rent_a_car_demo.dtos.responses.getListResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalListResponse {
    private int id;
    private Date rentalStartDate;
    private Date rentalEndDate;
}
