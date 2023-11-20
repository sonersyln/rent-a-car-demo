package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.models.Brand;
import com.example.rent_a_car_demo.models.Model;
import com.example.rent_a_car_demo.services.BrandService;
import com.example.rent_a_car_demo.services.ModelService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@AllArgsConstructor
public class ModelController {

    private ModelService modelService;



    @GetMapping("/getall")
    public List<Model> getBrandList() {

        return  this.modelService.getModelList();
    }

    @PostMapping()
    public String createBrand(@RequestBody Model model) {

        return this.modelService.createModel(model);
    }

    @PutMapping("/{id}")
    public String updateBrand(@PathVariable int id, @RequestBody Model brand) throws Exception {

        return this.modelService.updateModel(id, brand);
    }

    @DeleteMapping("/{id}")
    public String deleteBrand(@PathVariable int id) throws Exception {

        return this.modelService.deleteByModel(id);
    }
}
