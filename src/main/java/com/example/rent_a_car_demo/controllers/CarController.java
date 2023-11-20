package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.models.Car;
import com.example.rent_a_car_demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getall")
    public List<Car> getAllCar() {
        return carService.getAllCars();
    }

    @GetMapping("/get")
    public Car getCarById(@RequestParam(value = "id") Integer id) {
        return carService.getCarById(id);
    }

    @PostMapping("/add")
    public void saveCar(@RequestBody Car car) {
        carService.saveCar(car);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Integer id, @RequestBody Car car) {
        car.setId(id);
        carService.saveCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
    }
}
