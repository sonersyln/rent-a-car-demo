package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.models.Rental;
import com.example.rent_a_car_demo.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private final RentalService rentalService;
    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }
    @GetMapping("/getall")
    public List<Rental> getAllRentals(){return rentalService.getAllByRentals();}
    @GetMapping("/get")
    public Rental getRentalById(@RequestParam(value = "id") Integer id){return rentalService.getRentalById(id);
    }
    @PostMapping("/add")
    public void saveRental(@RequestBody Rental rental){rentalService.saveRental(rental);}
    @PutMapping("/{id}")
    public void updateRental(@PathVariable Integer id,@RequestBody Rental rental){
        rental.setId(id);
        rentalService.saveRental(rental);
    }
    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Integer id){rentalService.deleteRental(id);}
}
