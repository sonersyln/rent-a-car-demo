package com.example.rent_a_car_demo.services.dtos.requests.addRequests;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @NotNull(message = "Year can't be null")
    @NotBlank(message = "Year can't be blank")
    @DecimalMin(value = "1900", message = "Year must be at least 1900")
    private Integer year;
    @NotBlank(message = "Color can't be blank")
    @NotNull(message = "Color can't be null")
    private String color;
    @NotBlank(message = "Rental Fee can't be blank")
    @NotNull(message = "Rental Fee can't be null")
    private Double rentalFee;
    @NotBlank(message = "Licance Plate can't be blank")
    @NotNull(message = "Licance Plate can't be null")
    @Size(max = 11, message = "Licance Plate must be exactly 11 characters!")
    private String licencePlate;
}
