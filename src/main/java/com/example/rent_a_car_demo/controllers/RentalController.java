package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddRentalRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateRentalRequest;
import com.example.rent_a_car_demo.dtos.responses.GetRentalListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetRentalResponse;
import com.example.rent_a_car_demo.models.Rental;
import com.example.rent_a_car_demo.services.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @GetMapping("/getall")
    public List<GetRentalListResponse> getRentalList(){
        return this.rentalService.getRentalList();}
    @GetMapping("/{id}")
    public GetRentalResponse getRentalById(@PathVariable int id){
        return this.rentalService.getRentalById(id);
    }
    @PostMapping("/create")
    public String createRental(@RequestBody AddRentalRequest addRentalRequest){
        return this.rentalService.createRental(addRentalRequest);}
    @PutMapping("/update")
    public String updateRental(@RequestBody UpdateRentalRequest updateRentalRequest) throws Exception {
        return this.rentalService.updateRental(updateRentalRequest);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRental(@PathVariable int id) throws Exception {
        return this.rentalService.deleteByRental(id);}
}
