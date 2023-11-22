package com.example.rent_a_car_demo.services;

import com.example.rent_a_car_demo.dtos.requests.AddAddressRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateAddressRequest;
import com.example.rent_a_car_demo.dtos.responses.GetAddressListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetAddressResponse;
import com.example.rent_a_car_demo.models.Address;
import com.example.rent_a_car_demo.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<GetAddressListResponse> getAllAddresses() {
        List<Address> addresses = this.addressRepository.findAll();
        List<GetAddressListResponse> response = new ArrayList<>();

        for (Address address : addresses) {
            GetAddressListResponse listResponse = new GetAddressListResponse();

            listResponse.setAddress(address.getAddress());
            listResponse.setCity(address.getCity());
            listResponse.setCountry(address.getCountry());
            listResponse.setRegion(address.getRegion());
            listResponse.setZipCode(address.getZipCode());
            listResponse.setUsername(address.getUser().getUsername());


            response.add(listResponse);


        }
        return response;

    }


    public GetAddressResponse getAddressById(Integer id) {
        Address address = this.addressRepository.getReferenceById(id);
        GetAddressResponse response = new GetAddressResponse();

        response.setAddress(address.getAddress());
        response.setCity(address.getCity());
        response.setRegion(address.getRegion());
        response.setUsername(address.getUser().getUsername());
        response.setZipCode(address.getZipCode());
        response.setCountry(address.getCountry());

        return response;


    }

    public void saveAddress(AddAddressRequest address) {

        Address createAddress = new Address();

        createAddress.setAddress(address.getAddress());
        createAddress.setCity(address.getCity());
        createAddress.setRegion(address.getRegion());
        createAddress.setUser(address.getUser());
        createAddress.setZipCode(address.getZipCode());
        createAddress.setCountry(address.getCountry());

        addressRepository.save(createAddress);
    }


    public void updateAddress(int id, UpdateAddressRequest address) {

        Address createAddress = this.addressRepository.getReferenceById(id);

        createAddress.setAddress(address.getAddress());
        createAddress.setCity(address.getCity());
        createAddress.setRegion(address.getRegion());
        createAddress.setUser(address.getUser());
        createAddress.setZipCode(address.getZipCode());
        createAddress.setCountry(address.getCountry());

        addressRepository.save(createAddress);
    }

    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }


}
