package com.example.rent_a_car_demo.core.utilities.exceptions;

import lombok.NoArgsConstructor;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
