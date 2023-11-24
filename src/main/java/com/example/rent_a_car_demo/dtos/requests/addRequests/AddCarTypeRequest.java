package com.example.rent_a_car_demo.dtos.requests.addRequests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarTypeRequest {
    private String name;
}
