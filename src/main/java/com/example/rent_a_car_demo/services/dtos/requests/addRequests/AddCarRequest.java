package com.example.rent_a_car_demo.services.dtos.requests.addRequests;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "Licence Plate can't be blank")
    @NotNull(message = "Licence Plate can't be null")
    @Pattern(regexp = "(0[1-9]|[1-7][0-9]|8[01])[A-Z]{1,3}(\\d{2}|\\d{4})", message = "Invalid licence plate")
    @Size(min = 5, max = 9, message = "Licence plate must be between 5 and 9 characters")
    private String licencePlate;
}
