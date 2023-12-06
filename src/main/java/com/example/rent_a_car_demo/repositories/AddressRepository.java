package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.Address;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetAddressListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCountryOrCity(String country, String city);

    List<Address> findByCountryLike(String country);

    @Query("SELECT new com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetAddressListResponse(a.address, a.country, a.region, a.city, a.zipCode, a.user.username)" +
            "FROM Address a Where a.city LIKE %:city%")
    List<GetAddressListResponse> searchAddressByCity(String city);

    @Query("SELECT new com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetAddressListResponse(a.address, a.country, a.region, a.city, a.zipCode, a.user.username)" +
            "FROM Address a Where a.country IN :countryList")
    List<GetAddressListResponse> findByCountryIn(List<String> countryList);


}
