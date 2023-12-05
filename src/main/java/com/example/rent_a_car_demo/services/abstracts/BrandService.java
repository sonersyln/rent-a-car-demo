package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.models.Brand;
import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddBrandRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateBrandRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetBrandListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetBrandListResponse> getBrandList();
    GetBrandResponse getBrandById(Integer id);
    String createBrand(AddBrandRequest addBrandRequest);
    String updateBrand(UpdateBrandRequest updateBrandRequest ) throws Exception;
    String deleteByBrand(int id) throws Exception;
    List<GetBrandResponse> findByNameStartingWith(String name);
    List<GetBrandResponse> findByNameEndingWith(String name);
    List<GetBrandResponse> findDistinctByName(String name);
    List<GetBrandResponse> findByNameLengthGreaterThan(int length);
}
