package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateBrandRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetBrandListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetBrandResponse;
import com.example.rent_a_car_demo.models.Brand;
import com.example.rent_a_car_demo.repositories.BrandRepository;
import com.example.rent_a_car_demo.services.abstracts.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    public List<GetBrandListResponse> getBrandList() {
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> getBrandListResponse = new ArrayList<>();

        for (Brand brand : brandList) {
            GetBrandListResponse response = new GetBrandListResponse();
            response.setName(brand.getName());
            getBrandListResponse.add(response);
        }
        return getBrandListResponse;
    }

    public GetBrandResponse getBrandById(Integer id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }
    public String createBrand(AddBrandRequest addBrandRequest) {
        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());
        brandRepository.save(brand);

        return "Transaction Successful ";
    }

    public String updateBrand(UpdateBrandRequest updateBrandRequest ) throws Exception {
        Brand upToBrand = brandRepository.findById(updateBrandRequest.getId()).orElseThrow(() -> new Exception("Could not find Brand"));

        upToBrand.setName(updateBrandRequest.getName());
        this.brandRepository.save(upToBrand);
        return "Transaction Successful";

    }
    public String deleteByBrand(int id) throws Exception {

        this.brandRepository.findById(id).orElseThrow(() -> new Exception("Could not"));

        this.brandRepository.deleteById(id);
        return "Deletion successful";
    }
}
