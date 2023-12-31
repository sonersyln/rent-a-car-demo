package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddAddressRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateAddressRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetAddressListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetAddressResponse;

import java.util.List;

public interface AddressService {
    List<GetAddressListResponse> getAllAddresses();
    GetAddressResponse getAddressById(int id);
    void saveAddress(AddAddressRequest request);
    void updateAddress(int id, UpdateAddressRequest address);
    void deleteAddress(int id);

    List<GetAddressResponse> findByCountryOrCity(String country, String city);
    List<GetAddressResponse> findByCountryLike(String country);
    List<GetAddressListResponse> searchAddressByCity(String city);
    List<GetAddressListResponse> findByCountryIn(List<String> countryList);

}
