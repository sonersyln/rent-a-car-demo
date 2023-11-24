package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateBrandRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetBrandListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetBrandResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BrandService {
    List<GetBrandListResponse> getBrandList();
    GetBrandResponse getBrandById(Integer id);
    String createBrand(AddBrandRequest addBrandRequest);
    String updateBrand(UpdateBrandRequest updateBrandRequest ) throws Exception;
    String deleteByBrand(int id) throws Exception;
}
