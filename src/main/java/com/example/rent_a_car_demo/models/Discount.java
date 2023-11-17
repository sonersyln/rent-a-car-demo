package com.example.rent_a_car_demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "discount_code", nullable = false)
    private String discountCode;

    @Column(name = "percentage", nullable = false)
    private Double percentage;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
