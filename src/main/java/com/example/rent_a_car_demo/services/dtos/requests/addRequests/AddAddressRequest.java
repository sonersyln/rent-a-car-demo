package com.example.rent_a_car_demo.services.dtos.requests.addRequests;

import com.example.rent_a_car_demo.models.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {

    @NotBlank(message = "Address can't be blank!")
    @NotNull(message = "User can't be null!")
    private String address;
    @NotBlank(message = "Country can't be blank!")
    @NotNull(message = "User can't be null!")
    private String country;
    @NotBlank(message = "Region can't be blank!")
    @NotNull(message = "User can't be null!")
    private String region;
    @NotBlank(message = "City can't be blank!")
    @NotNull(message = "User can't be null!")
    private String city;
    @NotBlank(message = "Zip Code can't be blank!")
    @NotNull(message = "User can't be null!")
    @Size(min = 0, max = 5, message = "Zip Code must be exactly 5 characters!")
    private String zipCode;
    @NotNull(message = "User can't be null!")
    private User user;
}
