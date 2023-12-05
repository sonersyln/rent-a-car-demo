package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.Model;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetBrandListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    Model findByName(String name);

    List<Model> findByNameLike(String name);


    @Query("select new com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetModelListResponse(m.name,m.fuelType,m.enginePower," +
            "new com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetBrandResponse(m.brand.name)) " +
            "from Model m where m.enginePower =:enginePower And m.fuelType = : fuelType")
    List<GetBrandListResponse> findByEnginePowerAndFuelType (String enginePower, String fuelType);

}
