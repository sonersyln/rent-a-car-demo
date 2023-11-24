package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddCarTypeRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateCarTypeRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetCarTypeListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetCarTypeResponse;

import java.util.List;

public interface CarTypeService {
    List<GetCarTypeListResponse> getAllTypes();
    GetCarTypeResponse getCarTypeById(Integer id);
    String saveCarType(AddCarTypeRequest addCarTypeRequest);
    String updateCarType(UpdateCarTypeRequest updateCarTypeRequest) throws Exception;
    String deleteCarType(Integer id) throws Exception;
}
