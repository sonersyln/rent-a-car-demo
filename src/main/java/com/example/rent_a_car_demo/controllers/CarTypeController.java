package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.models.CarType;
import com.example.rent_a_car_demo.services.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartypes")
public class CarTypeController {
    private final CarTypeService carTypeService;

    @Autowired
    public CarTypeController(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }

    @GetMapping("/getall")
    public List<CarType> getAllTypes() {
        return carTypeService.getAllTypes();
    }

    @GetMapping("/get")
    public CarType getCarTypeById(@RequestParam(value = "id") Integer id) {
        return carTypeService.getCarTypeById(id);
    }

    @PostMapping("/add")
    public CarType saveCarType(@RequestBody CarType carType) {
        return carTypeService.saveCarType(carType);
    }

    @PutMapping()
    public void updateCarType(@RequestBody CarType carType) {
        carTypeService.updateCarType(carType);
    }

    @DeleteMapping("/{id}")
    public void deleteCarType(@PathVariable Integer id) {
        carTypeService.deleteCarType(id);
    }
}
