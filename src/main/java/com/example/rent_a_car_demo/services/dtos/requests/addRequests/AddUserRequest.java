package com.example.rent_a_car_demo.services.dtos.requests.addRequests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern.List({
            @Pattern(regexp = "^(?=.*[A-Z]).*$", message = "Password must contain at least one uppercase letter"),
            @Pattern(regexp = "^(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\"<>,.?/~]).*$",
                    message = "Password must contain at least one special character")
    })
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private Date birthDate;
}
