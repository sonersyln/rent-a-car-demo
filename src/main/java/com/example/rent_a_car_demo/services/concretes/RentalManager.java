package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddRentalRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateRentalRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetRentalListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetRentalResponse;
import com.example.rent_a_car_demo.models.Rental;
import com.example.rent_a_car_demo.repositories.RentalRepository;
import com.example.rent_a_car_demo.services.abstracts.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;


    public List<GetRentalListResponse> getRentalList() {
        List<Rental> rentalList = rentalRepository.findAll();
        List<GetRentalListResponse> getRentalListResponse = new ArrayList<>();

        for (Rental rental : rentalList) {
            GetRentalListResponse response = new GetRentalListResponse();
            response.setId(rental.getId());
            getRentalListResponse.add(response);
        }
        return getRentalListResponse;
    }

    public GetRentalResponse getRentalById(Integer id){
        Rental rental = rentalRepository.findById(id).orElseThrow();

        GetRentalResponse dto = new GetRentalResponse();

        dto.setRentalStartDate(rental.getRentalStartDate());
        dto.setRentalEndDate(rental.getRentalEndDate());

        return dto;
    }
    public String createRental(AddRentalRequest addRentalRequest) {
        Rental rental = new Rental();
        rental.setRentalStartDate(addRentalRequest.getRentalStartDate());
        rental.setRentalEndDate(addRentalRequest.getRentalEndDate());
        rental.setTotalCost(addRentalRequest.getTotalCost());
        rentalRepository.save(rental);
        return "Rental Created";
    }
    public String updateRental(UpdateRentalRequest updateRentalRequest) {
        Rental rental = rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();
        rental.setRentalStartDate(updateRentalRequest.getRentalStartDate());
        rental.setRentalEndDate(updateRentalRequest.getRentalEndDate());
        rental.setTotalCost(updateRentalRequest.getTotalCost());
        rentalRepository.save(rental);
        return "Rental Updated";
    }
    public String deleteByRental(Integer id) throws Exception {
       this.rentalRepository.findById(id).orElseThrow(() -> new Exception("Could not find"));
       this.rentalRepository.deleteById(id);
       return "Deletion successful";
    }

}
