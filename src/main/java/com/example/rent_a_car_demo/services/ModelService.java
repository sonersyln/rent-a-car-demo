package com.example.rent_a_car_demo.services;

import com.example.rent_a_car_demo.models.Model;
import com.example.rent_a_car_demo.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelService {

    private ModelRepository modelRepository;


    public List<Model> getModelList() {

        return this.modelRepository.findAll();
    }

    public String createModel(Model model) {

        this.modelRepository.save(model);

        return "Transactional Successfully Created Model";
    }

    public String updateModel(int id , Model model ) throws Exception {
        Model model1 = modelRepository.findById(id).orElseThrow(() -> new Exception("Could not find Brand"));

        model1.setName(model.getName());
        model1.setFuelType(model.getFuelType());
        model1.setEnginePower(model.getEnginePower());
        model1.setBrand(model.getBrand());
        model1.setCars(model.getCars());
        this.modelRepository.save(model1);

        return  "Transactional Successfully Updated Model";

    }
    public String deleteByModel(int id) throws Exception {

        this.modelRepository.findById(id).orElseThrow(() -> new Exception("Could not"));

        this.modelRepository.deleteById(id);
        return "Deletion successful";
    }


}
