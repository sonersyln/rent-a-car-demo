package com.example.rent_a_car_demo.services.dtos.requests.addRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {
    @NotBlank(message = "Marka adı boş olamaz.")
   // @Size(min=3, max= 20)
    @Length(min=3, max= 20, message = "Marka adı 3 ile 20 hane arasında olmalıdır.")
    private String name;
}
