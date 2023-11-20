package com.example.rent_a_car_demo.repositories;
import com.example.rent_a_car_demo.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
