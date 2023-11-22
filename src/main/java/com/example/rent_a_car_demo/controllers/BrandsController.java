package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateBrandRequest;
import com.example.rent_a_car_demo.dtos.responses.GetBrandListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetBrandResponse;
import com.example.rent_a_car_demo.services.BrandService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;
    @GetMapping("/getall")
    public List<GetBrandListResponse> getBrandList() {

       return  this.brandService.getBrandList();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getBrandById(@PathVariable int id) {
        return this.brandService.getBrandById(id);
    }

    @PostMapping("/create")
    public String createBrand(@RequestBody AddBrandRequest addBrandRequest) {

        return this.brandService.createBrand(addBrandRequest);
    }

    @PutMapping("/update")
    public String updateBrand(@RequestBody UpdateBrandRequest updateBrandRequest) throws Exception {

        return this.brandService.updateBrand(updateBrandRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable int id) throws Exception {

        return this.brandService.deleteByBrand(id);
    }
}
