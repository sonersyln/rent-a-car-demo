package com.example.rent_a_car_demo.services;

import com.example.rent_a_car_demo.models.Brand;
import com.example.rent_a_car_demo.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {

    private BrandRepository brandRepository;

    public List<Brand> getBrandList() {

        return this.brandRepository.findAll();
    }

    public String createBrand(Brand brand) {

        this.brandRepository.save(brand);

        return "Transaction Successful ";
    }

    public String updateBrand(int id , Brand brand ) throws Exception {
        Brand upToBrand = brandRepository.findById(id).orElseThrow(() -> new Exception("Could not find Brand"));

        upToBrand.setName(brand.getName());
        upToBrand.setBrands(brand.getBrands());
        this.brandRepository.save(upToBrand);

        return "Transaction Successful ";

    }
    public String deleteByBrand(int id) throws Exception {

        this.brandRepository.findById(id).orElseThrow(() -> new Exception("Could not"));

        this.brandRepository.deleteById(id);
        return "Deletion successful";
    }
}
