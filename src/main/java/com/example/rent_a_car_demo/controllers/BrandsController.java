package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddBrandRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateBrandRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetBrandListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetBrandResponse;
import com.example.rent_a_car_demo.services.abstracts.BrandService;
import jakarta.validation.Valid;
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
    public String createBrand(@RequestBody @Valid AddBrandRequest addBrandRequest) {

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
    @GetMapping("/start-with/{name}")
    public List<GetBrandResponse> getBrandsStartingWith(@PathVariable String name) {
        return this.brandService.findByNameStartingWith(name);
    }

    @GetMapping("/end-with/{name}")
    public List<GetBrandResponse> getBrandsEndingWith(@PathVariable String name) {
        return brandService.findByNameEndingWith(name);
    }

    @GetMapping("/distinct/{name}")
    public List<GetBrandResponse> getDistinctBrandsByName(@PathVariable String name) {
        return brandService.findDistinctByName(name);
    }

    @GetMapping("/length-greater-than/{length}")
    public List<GetBrandResponse> getBrandsByNameLengthGreaterThan(@PathVariable int length) {
        return brandService.findByNameLengthGreaterThan(length);
    }
}
