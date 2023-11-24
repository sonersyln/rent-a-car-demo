package com.example.rent_a_car_demo.dtos.requests.updateRequests;

import com.example.rent_a_car_demo.models.Brand;
import com.example.rent_a_car_demo.models.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {


    private String name;

    private String fuelType;

    private String enginePower;

    private Brand brand;



}
