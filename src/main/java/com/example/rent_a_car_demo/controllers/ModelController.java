package com.example.rent_a_car_demo.controllers;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddModelRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateModelRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetModelListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetModelResponse;
import com.example.rent_a_car_demo.services.abstracts.ModelService;

import lombok.AllArgsConstructor;
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

    @GetMapping("/findbyname")
    public GetModelResponse findByName(@RequestParam String name){

        return this.modelService.findByName(name);

    }
    @GetMapping("/findbynamelike")
    public List<GetModelListResponse> findByNameLike(@RequestParam String name){

        return this.modelService.findByNameLike("%"+name+"%");

    }
    @GetMapping("/searchBy")
    public List<GetModelListResponse> searchBy(@RequestParam String fuelType , @RequestParam String enginePower){

        return this.modelService.searchBy(fuelType, enginePower);
    }
}
