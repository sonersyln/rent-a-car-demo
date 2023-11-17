package com.example.rent_a_car_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "address", length = 150, nullable = false)
    private String address;

    @Column(name = "country", length = 30, nullable = false)
    private String country;

    @Column(name = "region", length = 20, nullable = false)
    private String region;

    @Column(name = "city", length = 30, nullable = false)
    private String city;

    @Column(name = "zip_code", length = 10, nullable = false)
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
