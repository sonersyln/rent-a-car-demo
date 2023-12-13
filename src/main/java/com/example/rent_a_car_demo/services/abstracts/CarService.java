package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddCarRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateCarRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetCarListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetByIdCarResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetCarResponse;

import java.util.List;

public interface CarService {

    List<GetCarListResponse> getAllCars();
    GetByIdCarResponse getById(Integer id);
    String saveCar(AddCarRequest addCarRequest);
    String updateCar(UpdateCarRequest updateCarRequest) throws Exception;
    String deleteCar(Integer id) throws Exception;
    List<GetCarResponse> getCarsByColorIgnoreCase(String color);

    List<GetCarResponse> getCarsByYearAndColorOrderByRentalFeeDesc(Integer year, String color);

    List<GetCarResponse> getCarsByYearAndColorOrRentalFeeLessThan(Integer year, String color, Double rentalFee);

    List<GetCarResponse> getCarsByRentalFeeBetween(Double minRentalFee, Double maxRentalFee);

}
