package com.example.rent_a_car_demo.services.dtos.requests.updateRequests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarTypeRequest {
    private int id;
    private String name;
}
