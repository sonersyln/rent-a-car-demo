package com.example.rent_a_car_demo.services;

import com.example.rent_a_car_demo.models.CarType;
import com.example.rent_a_car_demo.repositories.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypeService {
    private final CarTypeRepository carTypeRepository;

    @Autowired
    public CarTypeService(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

    public List<CarType> getAllTypes() {
        return carTypeRepository.findAll();
    }

    public CarType getCarTypeById(Integer id) {
        return carTypeRepository.findById(id).orElseThrow();
    }

    public CarType saveCarType(CarType carType) {
        carTypeRepository.save(carType);
        return carType;
    }

    public void deleteCarType(Integer id) {
        carTypeRepository.deleteById(id);
    }

    public void updateCarType(CarType carType) {

        carTypeRepository.save(carType);
    }

}
