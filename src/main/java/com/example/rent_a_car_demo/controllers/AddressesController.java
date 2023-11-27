package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddAddressRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateAddressRequest;
import com.example.rent_a_car_demo.dtos.responses.GetAddressListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetAddressResponse;
import com.example.rent_a_car_demo.services.AddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressesController {

    private final AddressManager addressManager;

    @Autowired
    public AddressesController(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    @GetMapping("/getall")
    public List<GetAddressListResponse> getAllAddresses() {
        return addressManager.getAllAddresses();
    }

    @GetMapping("/get")
    public GetAddressResponse getAddressById(@RequestParam(value = "id") Integer id) {
        return addressManager.getAddressById(id);
    }

    @PostMapping("/add")
    public void saveAddress(@RequestBody AddAddressRequest request) {
        addressManager.saveAddress(request);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable Integer id, @RequestBody UpdateAddressRequest address) {

        addressManager.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressManager.deleteAddress(id);
    }
}