package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddModelRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateModelRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetModelListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetModelResponse;

import java.util.List;

public interface ModelService {
    List<GetModelListResponse> getModelList();
    GetModelResponse getModelResponse(int id) throws Exception;
    String createModel(AddModelRequest request);
    String updateModel(int id, UpdateModelRequest request) throws Exception;
    String deleteByModel(int id) throws Exception;
}
