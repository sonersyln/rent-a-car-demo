package com.example.rent_a_car_demo.services.dtos.requests.addRequests;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarTypeRequest {
    @NotNull(message = "Car Type can't be null")
    @NotBlank(message = "Car Type can't be blank")
    private String name;
}
