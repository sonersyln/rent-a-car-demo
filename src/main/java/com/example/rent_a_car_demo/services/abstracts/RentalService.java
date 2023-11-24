package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddRentalRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateRentalRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetRentalListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetRentalResponse;

import java.util.List;

public interface RentalService {
    List<GetRentalListResponse> getRentalList();
    GetRentalResponse getRentalById(Integer id);
    String createRental(AddRentalRequest addRentalRequest);
    String updateRental(UpdateRentalRequest updateRentalRequest);
    String deleteByRental(Integer id) throws Exception;


}
