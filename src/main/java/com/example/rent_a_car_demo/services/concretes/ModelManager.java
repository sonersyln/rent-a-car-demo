package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddModelRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateModelRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetModelListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetBrandResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetModelResponse;
import com.example.rent_a_car_demo.models.Model;
import com.example.rent_a_car_demo.repositories.ModelRepository;
import com.example.rent_a_car_demo.services.abstracts.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;


    public List<GetModelListResponse> getModelList() {
        List<Model> models = this.modelRepository.findAll();
        List<GetModelListResponse> responses = new ArrayList<>();

        for (Model model : models) {
            GetModelListResponse response = new GetModelListResponse();

            response.setName(model.getName());
            response.setEnginePower(model.getEnginePower());
            response.setFuelType(model.getFuelType());
            response.setBrand(new GetBrandResponse(model.getBrand().getName()));

            responses.add(response);

        }
        return responses;

    }

    public GetModelResponse getModelResponse(int id) throws Exception {
        GetModelResponse response = new GetModelResponse();
        Model model1 = modelRepository.findById(id).orElseThrow(() -> new Exception("Could not find Brand"));

        response.setName(model1.getName());
        response.setEnginePower(model1.getEnginePower());
        response.setFuelType(model1.getFuelType());
        response.setGetBrandResponse(new GetBrandResponse(model1.getBrand().getName()));;


        return response;


    }


    public String createModel(AddModelRequest request) {
        Model model = new Model();

        model.setName(request.getName());
        model.setEnginePower(request.getEnginePower());
        model.setFuelType(request.getFuelType());
        model.setBrand(request.getBrand());

        this.modelRepository.save(model);

        return "Transactional Successfully Created Model";
    }

    public String updateModel(int id, UpdateModelRequest request) throws Exception {
        Model model1 = modelRepository.findById(id).orElseThrow(() -> new Exception("Could not find Brand"));

        model1.setName(request.getName());
        model1.setFuelType(request.getFuelType());
        model1.setEnginePower(request.getEnginePower());
        model1.setBrand(request.getBrand());

        this.modelRepository.save(model1);

        return "Transactional Successfully Updated Model";

    }

    public String deleteByModel(int id) throws Exception {

        this.modelRepository.findById(id).orElseThrow(() -> new Exception("Could not"));

        this.modelRepository.deleteById(id);
        return "Deletion successful";
    }
    public GetModelResponse findByName(String name){
      Model model = this.modelRepository.findByName(name);
     GetModelResponse response = new GetModelResponse();
     response.setName(model.getName());
     response.setEnginePower(model.getEnginePower());
     response.setFuelType(model.getFuelType());
     response.setGetBrandResponse(new GetBrandResponse(model.getBrand().getName()));


        return response;
    }

    public  List<GetModelListResponse> findByNameLike(String name){
        List<Model> models = this.modelRepository.findByNameLike(name);
        List<GetModelListResponse> responses = new ArrayList<>();
        for (Model  model:  models) {
            GetModelResponse response = new GetModelResponse();

            response.setName(model.getName());
            response.setEnginePower(model.getEnginePower());
            response.setFuelType(model.getFuelType());
            response.setGetBrandResponse(new GetBrandResponse(model.getBrand().getName()));
        }


        return responses;
    }


}
