package com.example.rent_a_car_demo.repository;
import com.example.rent_a_car_demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
