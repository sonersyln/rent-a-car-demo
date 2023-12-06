package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.models.Brand;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    //verilen metin ile başlayan tüm markaları bulma
    List<Brand> findByNameStartingWith(String name);
    //verilen metin ile biten tüm markaları bulma
    List<Brand> findByNameEndingWith(String name);
    boolean existsByName(String name);
    //Benzersiz marka isimlerini bulma
    @Query("SELECT DISTINCT new com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetBrandResponse(b.name)" +
            "FROM Brand b Where b.name = :name")
    List<GetBrandResponse> findDistinctByName(String name);
    //Belirtilen karakterden uzun markaları listeleme
    @Query("SELECT new com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetBrandResponse(b.name)" +
            " FROM Brand b WHERE LENGTH(b.name) > :length")
    List<GetBrandResponse> findByNameLengthGreaterThan(int length);

}
