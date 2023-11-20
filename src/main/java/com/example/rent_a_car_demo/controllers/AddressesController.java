package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.models.Address;
import com.example.rent_a_car_demo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressesController {

    private final AddressService addressService;

    @Autowired
    public AddressesController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getall")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/get")
    public Address getAddressById(@RequestParam(value ="id") Integer id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/add")
    public void saveAddress(@RequestBody Address address) {
        addressService.saveAddress(address);
    }

    @PutMapping ("/{id}")
    public void updateAddress(@PathVariable Integer id, @RequestBody Address address) {
        address.setId(id);
        addressService.saveAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }
}