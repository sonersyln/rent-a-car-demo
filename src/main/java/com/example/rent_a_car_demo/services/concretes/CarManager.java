package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.core.utilities.mappers.ModelMapperService;
import com.example.rent_a_car_demo.models.Car;
import com.example.rent_a_car_demo.repositories.CarRepository;
import com.example.rent_a_car_demo.services.abstracts.CarService;
import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddCarRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateCarRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetCarListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetCarResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetCarTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private ModelMapperService modelMapperService;


    public List<GetCarListResponse> getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<GetCarListResponse> carsResponse = cars.stream().map(car -> this.modelMapperService
                .forResponse().map(car, GetCarListResponse.class)).collect(Collectors.toList());
        ;
        return carsResponse;
       /* List<GetCarListResponse> getCarListResponses = new ArrayList<>();

        for (Car car : cars) {
            GetCarListResponse dto = new GetCarListResponse();
            dto.setColor(car.getColor());
            dto.setYear(car.getYear());
            dto.setRentalFee(car.getRentalFee());
            dto.setLicencePlate(car.getLicencePlate());
            getCarListResponses.add(dto);
        }*/

    }

    public GetCarResponse getCarById(Integer id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse dto = new GetCarResponse();
        dto.setColor(car.getColor());
        dto.setYear(car.getYear());
        dto.setRentalFee(car.getRentalFee());
        dto.setLicencePlate(car.getLicencePlate());

        return dto;
    }

    public String saveCar(AddCarRequest addCarRequest) {
        boolean result = carRepository.existsByLicencePlate(addCarRequest.getLicencePlate());
        if (result) {
            throw new RuntimeException("Car already exists");
        }

        Car car = this.modelMapperService.forRequest().map(addCarRequest, Car.class);
        this.carRepository.save(car);

        return "Transaction Successful ";
    }

    public String updateCar(UpdateCarRequest updateCarRequest) throws Exception {
        Car upToCar = carRepository.findById(updateCarRequest.getId()).orElseThrow(() -> new Exception("Car not found!"));

        upToCar.setColor(updateCarRequest.getColor());
        upToCar.setYear(updateCarRequest.getYear());
        upToCar.setRentalFee(updateCarRequest.getRentalFee());
        upToCar.setLicencePlate(updateCarRequest.getLicencePlate());
        this.carRepository.save(upToCar);

        return "Transaction Successful!";
    }

    public String deleteCar(Integer id) throws Exception {
        this.carRepository.findById(id).orElseThrow(() -> new Exception("Car not found!"));

        this.carRepository.deleteById(id);
        return "Delete Successful!";
    }

    @Override
    public List<GetCarResponse> getCarsByColorIgnoreCase(String color) {
        List<Car> cars = this.carRepository.findByColorIgnoreCase(color);
        List<GetCarResponse> response = new ArrayList<>();

        for (Car car : cars) {
            GetCarResponse getResponse = new GetCarResponse();

            getResponse.setColor(car.getColor());
            getResponse.setYear(car.getYear());
            getResponse.setRentalFee(car.getRentalFee());
            getResponse.setLicencePlate(car.getLicencePlate());
            getResponse.setCarType(new GetCarTypeResponse(car.getCarType().getName()));

            response.add(getResponse);
        }
        return response;
    }

    @Override
    public List<GetCarResponse> getCarsByYearAndColorOrderByRentalFeeDesc(Integer year, String color) {
        List<Car> cars = this.carRepository.findByYearAndColorOrderByRentalFeeDesc(year, color);
        List<GetCarResponse> response = new ArrayList<>();

        for (Car car : cars) {
            GetCarResponse getResponse = new GetCarResponse();

            getResponse.setColor(car.getColor());
            getResponse.setYear(car.getYear());
            getResponse.setRentalFee(car.getRentalFee());
            getResponse.setLicencePlate(car.getLicencePlate());
            getResponse.setCarType(new GetCarTypeResponse(car.getCarType().getName()));

            response.add(getResponse);
        }
        return response;
    }

    @Override
    public List<GetCarResponse> getCarsByYearAndColorOrRentalFeeLessThan(Integer year, String color, Double rentalFee) {
        return carRepository.findByYearAndColorOrRentalFeeLessThan(year, color, rentalFee);
    }

    @Override
    public List<GetCarResponse> getCarsByRentalFeeBetween(Double minRentalFee, Double maxRentalFee) {
        return carRepository.findByRentalFeeBetween(minRentalFee, maxRentalFee);
    }

}
