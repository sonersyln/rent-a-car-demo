package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddCarRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateCarRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetCarListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetCarResponse;
import com.example.rent_a_car_demo.services.abstracts.CarService;
import jakarta.validation.Valid;
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
    public String saveCar(@RequestBody @Valid AddCarRequest addCarRequest) {
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

    @GetMapping("/byColorIgnoreCase/{color}")
    public List<GetCarResponse> getCarsByColorIgnoreCase(@PathVariable String color) {
        return carService.getCarsByColorIgnoreCase(color);
    }

    @GetMapping("/byYearAndColorOrderByRentalFeeDesc/{year}/{color}")
    public List<GetCarResponse> getCarsByYearAndColorOrderByRentalFeeDesc(
            @PathVariable Integer year,
            @PathVariable String color) {
        return carService.getCarsByYearAndColorOrderByRentalFeeDesc(year, color);
    }

    @GetMapping("/byYearAndColorOrRentalFeeLessThan/{year}/{color}/{rentalFee}")
    public List<GetCarResponse> getCarsByYearAndColorOrRentalFeeLessThan(
            @PathVariable Integer year,
            @PathVariable String color,
            @PathVariable Double rentalFee) {
        return carService.getCarsByYearAndColorOrRentalFeeLessThan(year, color, rentalFee);
    }

    @GetMapping("/byRentalFeeBetween/{minRentalFee}/{maxRentalFee}")
    public List<GetCarResponse> getCarsByRentalFeeBetween(
            @PathVariable Double minRentalFee,
            @PathVariable Double maxRentalFee) {
        return carService.getCarsByRentalFeeBetween(minRentalFee, maxRentalFee);
    }
}
