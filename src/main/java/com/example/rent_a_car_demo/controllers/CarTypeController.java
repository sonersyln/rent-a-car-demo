package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddCarTypeRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateCarTypeRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetCarTypeListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetCarTypeResponse;
import com.example.rent_a_car_demo.services.abstracts.CarTypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cartypes")
public class CarTypeController {
    private final CarTypeService carTypeService;


    @GetMapping("/getall")
    public List<GetCarTypeListResponse> getAllTypes() {
        return carTypeService.getAllTypes();
    }

    @GetMapping("/get")
    public GetCarTypeResponse getCarTypeById(@RequestParam(value = "id") Integer id) {
        return carTypeService.getCarTypeById(id);
    }

    @PostMapping("/add")
    public String saveCarType(@RequestBody AddCarTypeRequest addCarTypeRequest) {
        return carTypeService.saveCarType(addCarTypeRequest);
    }

    @PutMapping()
    public String updateCarType(@RequestBody UpdateCarTypeRequest updateCarTypeRequest) throws Exception {
       return carTypeService.updateCarType(updateCarTypeRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteCarType(@PathVariable Integer id) throws Exception {
       return carTypeService.deleteCarType(id);
    }
}
