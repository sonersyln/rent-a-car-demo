package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddCarRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateCarRequest;
import com.example.rent_a_car_demo.dtos.responses.GetCarListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetCarResponse;
import com.example.rent_a_car_demo.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;


    @GetMapping("/getall")
    public List<GetCarListResponse> getAllCar() {
        return this.carService.getAllCars();
    }

    @GetMapping("/get")
    public GetCarResponse getCarById(@RequestParam(value = "id") Integer id) {
        return carService.getCarById(id);
    }

    @PostMapping("/add")
    public String saveCar(@RequestBody AddCarRequest addCarRequest) {
        return carService.saveCar(addCarRequest);
    }

    @PutMapping("/update")
    public String updateCar(@RequestBody UpdateCarRequest updateCarRequest) throws Exception {
        return this.carService.updateCar(updateCarRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable Integer id) throws Exception {
        return this.carService.deleteCar(id);
    }
}
