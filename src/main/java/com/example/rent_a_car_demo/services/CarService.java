package com.example.rent_a_car_demo.services;

import com.example.rent_a_car_demo.dtos.requests.AddCarRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateCarRequest;
import com.example.rent_a_car_demo.dtos.responses.GetCarListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetCarResponse;
import com.example.rent_a_car_demo.models.Car;
import com.example.rent_a_car_demo.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;


    public List<GetCarListResponse> getAllCars() {
        List<Car> carList = carRepository.findAll();
        List<GetCarListResponse> getCarListResponses = new ArrayList<>();

        for (Car car : carList) {
            GetCarListResponse dto = new GetCarListResponse();
            dto.setColor(car.getColor());
            dto.setYear(car.getYear());
            dto.setRentalFee(car.getRentalFee());
            dto.setLicencePlate(car.getLicencePlate());
            getCarListResponses.add(dto);
        }
        return getCarListResponses;
    }

    public GetCarResponse getCarById(Integer id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setColor(car.getColor());
        dto.setYear(car.getYear());
        dto.setRentalFee(car.getRentalFee());
        dto.setLicencePlate(car.getLicencePlate());

        return dto;
    }

    public String saveCar(AddCarRequest addCarRequest) {
        Car car = new Car();
        car.setColor(addCarRequest.getColor());
        car.setYear(addCarRequest.getYear());
        car.setRentalFee(addCarRequest.getRentalFee());
        car.setLicencePlate(addCarRequest.getLicencePlate());
        carRepository.save(car);

        return "Transaction Successful ";
    }

    public String updateCar(UpdateCarRequest updateCarRequest) throws Exception {
        Car upToCar = carRepository.findById(updateCarRequest.getId()).orElseThrow(() -> new Exception("Car not found!"));

        upToCar.setColor(updateCarRequest.getColor());
        upToCar.setYear(updateCarRequest.getYear());
        upToCar.setRentalFee(updateCarRequest.getRentalFee());
        upToCar.setLicencePlate(updateCarRequest.getLicencePlate());
        this.carRepository.save(upToCar);

        return "Transaction Successful!";
    }

    public String deleteCar(Integer id) throws Exception {
        this.carRepository.findById(id).orElseThrow(() -> new Exception("Car not found!"));

        this.carRepository.deleteById(id);
        return "Delete Successful!";
    }

}
