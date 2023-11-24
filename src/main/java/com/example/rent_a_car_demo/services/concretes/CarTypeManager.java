package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddCarTypeRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateCarTypeRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetCarTypeListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetCarTypeResponse;
import com.example.rent_a_car_demo.models.CarType;
import com.example.rent_a_car_demo.repositories.CarTypeRepository;
import com.example.rent_a_car_demo.services.abstracts.CarTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarTypeManager implements CarTypeService {
    private final CarTypeRepository carTypeRepository;

    public List<GetCarTypeListResponse> getAllTypes() {
        List<CarType> carTypeList = carTypeRepository.findAll();
            List<GetCarTypeListResponse> getCarTypeListResponse = new ArrayList<>();

            for (CarType carType : carTypeList) {
                GetCarTypeListResponse dto = new GetCarTypeListResponse();
                dto.setName(carType.getName());
                getCarTypeListResponse.add(dto);
        }
        return getCarTypeListResponse;
    }

    public GetCarTypeResponse getCarTypeById(Integer id) {
        CarType carType = carTypeRepository.findById(id).orElseThrow();

        GetCarTypeResponse dto = new GetCarTypeResponse();
        dto.setName(carType.getName());

        return dto;
    }

    public String saveCarType(AddCarTypeRequest addCarTypeRequest) {
        CarType carType = new CarType();
        carType.setName(addCarTypeRequest.getName());
        carTypeRepository.save(carType);

        return "Transaction Successful ";
    }

    public String updateCarType(UpdateCarTypeRequest updateCarTypeRequest) throws Exception {
        CarType upToCarType = carTypeRepository.findById(updateCarTypeRequest.getId()).orElseThrow(() -> new Exception("CarType not found!"));

        upToCarType.setName(updateCarTypeRequest.getName());
        this.carTypeRepository.save(upToCarType);
        return "Transaction Successful";
    }

    public String deleteCarType(Integer id) throws Exception {
        this.carTypeRepository.findById(id).orElseThrow(() -> new Exception("CarType not found!"));

        this.carTypeRepository.deleteById(id);
        return "Delete Successful!";
    }

}
