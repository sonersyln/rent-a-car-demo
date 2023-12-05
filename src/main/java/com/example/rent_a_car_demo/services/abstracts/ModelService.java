package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.models.Model;
import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddModelRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateModelRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetModelListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetBrandResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetModelResponse;

import java.util.List;

public interface ModelService {
    List<GetModelListResponse> getModelList();
    GetModelResponse getModelResponse(int id) throws Exception;
    String createModel(AddModelRequest request);
    String updateModel(int id, UpdateModelRequest request) throws Exception;
    String deleteByModel(int id) throws Exception;

    GetModelResponse findByName(String name);
    List<GetModelListResponse> findByNameLike(String name);
}
