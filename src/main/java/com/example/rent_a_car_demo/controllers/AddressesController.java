package com.example.rent_a_car_demo.controllers;


import com.example.rent_a_car_demo.services.concretes.AddressManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.rent_a_car_demo.services.abstracts.AddressService;
import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddAddressRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateAddressRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetAddressListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetAddressResponse;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressesController {

    private final AddressService addressManager;


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

    @GetMapping()
    public List<GetAddressResponse> findByCountryOrCity(@RequestParam String country, @RequestParam String city) {
        return addressManager.findByCountryOrCity(country, city);
    }

    @GetMapping("/findByCountryLike")
    public List<GetAddressResponse> findByCountryLike(@RequestParam String country) {
        return addressManager.findByCountryLike(country);
    }

    @GetMapping("/findByCountryIn")
    public List<GetAddressListResponse> findByCountryIn(@RequestParam List<String> country) {
        return addressManager.findByCountryIn(country);


    }

    @GetMapping("/findByCityLike")
    public List<GetAddressListResponse> searchAddressByCity(@RequestParam String city) {
        return addressManager.searchAddressByCity(city);
    }

}