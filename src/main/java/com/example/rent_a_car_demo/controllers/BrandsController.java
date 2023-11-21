package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.models.Brand;
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
    public List<Brand> getBrandList() {

       return  this.brandService.getBrandList();
    }

    @PostMapping("/create")
    public String createBrand(@RequestBody Brand brand) {

        return this.brandService.createBrand(brand);
    }

    @PutMapping("/update/{id}")
    public String updateBrand(@PathVariable int id, @RequestBody Brand brand) throws Exception {

        return this.brandService.updateBrand(id, brand);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable int id) throws Exception {

        return this.brandService.deleteByBrand(id);
    }
}
