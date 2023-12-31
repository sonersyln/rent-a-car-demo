package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.services.abstracts.AddressService;
import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddAddressRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateAddressRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetAddressListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetAddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
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
    public void saveAddress(@RequestBody @Valid AddAddressRequest request) {
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

    @GetMapping()
    public List<GetAddressResponse> findByCountryOrCity(@RequestParam String country, @RequestParam String city) {
        return addressService.findByCountryOrCity(country, city);
    }

    @GetMapping("/findByCountryLike")
    public List<GetAddressResponse> findByCountryLike(@RequestParam String country) {
        return addressService.findByCountryLike(country);
    }

    @GetMapping("/findByCountryIn")
    public List<GetAddressListResponse> findByCountryIn(@RequestParam List<String> country) {
        return addressService.findByCountryIn(country);


    }

    @GetMapping("/findByCityLike")
    public List<GetAddressListResponse> searchAddressByCity(@RequestParam String city) {
        return addressService.searchAddressByCity(city);
    }

}