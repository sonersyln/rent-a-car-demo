package com.example.rent_a_car_demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "color", nullable = false, length = 20)
    private String color;

    @Column(name = "rental_fee", nullable = false)
    private Double rentalFee;

    @Column(name = "licence_plate", nullable = false, length = 11, unique = true)
    private String licencePlate;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false )
    private Model model;

    @ManyToOne
    @JoinColumn(name = "car_type_id", nullable = false)
    private CarType carType;

    @OneToMany (mappedBy = "car")
    @JsonIgnore
    private List<Rental> rentals;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Review> reviews;
}
