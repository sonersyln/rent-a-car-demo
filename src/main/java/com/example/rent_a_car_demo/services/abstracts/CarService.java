package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddCarRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateCarRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetCarListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetCarResponse;

import java.util.List;

public interface CarService {
    List<GetCarListResponse> getAllCars();
    GetCarResponse getCarById(Integer id);
    String saveCar(AddCarRequest addCarRequest);
    String updateCar(UpdateCarRequest updateCarRequest) throws Exception;
    String deleteCar(Integer id) throws Exception;
}
