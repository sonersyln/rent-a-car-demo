package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddModelRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateModelRequest;
import com.example.rent_a_car_demo.dtos.responses.GetModelListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetModelResponse;
import com.example.rent_a_car_demo.models.Brand;
import com.example.rent_a_car_demo.models.Model;
import com.example.rent_a_car_demo.services.BrandService;
import com.example.rent_a_car_demo.services.ModelService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/models")
@AllArgsConstructor
public class ModelController {

    private ModelService modelService;



    @GetMapping("/getall")
    public List<GetModelListResponse > getModelList() {

        return  this.modelService.getModelList();
    }
    @GetMapping("{id}")
    public GetModelResponse getModelResponse(@PathVariable  int id) throws Exception {

    return this.modelService.getModelResponse(id);
    }
    @PostMapping("/create")
        public String createModel(@RequestBody AddModelRequest model) {

        return this.modelService.createModel(model);
    }

    @PutMapping("/update/{id}")
    public String updateModel(@PathVariable int id, @RequestBody UpdateModelRequest model) throws Exception {

        return this.modelService.updateModel(id, model);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteModel(@PathVariable int id) throws Exception {

        return this.modelService.deleteByModel(id);
    }
}
