package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddAddressRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateAddressRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetAddressListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetAddressResponse;
import com.example.rent_a_car_demo.services.abstracts.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressesController {

    private final AddressService addressService;


    @GetMapping("/getall")
    public List<GetAddressListResponse> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/get")
    public GetAddressResponse getAddressById(@RequestParam(value = "id") Integer id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/add")
    public void saveAddress(@RequestBody AddAddressRequest request) {
        addressService.saveAddress(request);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable Integer id, @RequestBody UpdateAddressRequest address) {

        addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }
}