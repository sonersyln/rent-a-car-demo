package com.example.rent_a_car_demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @Column(name = "id",  nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "name", nullable = false)
    private String name ;
    @OneToMany(mappedBy = "brand")
    private List<Model> models;

}
