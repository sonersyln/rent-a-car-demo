package com.example.rent_a_car_demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Address> addresses;

    @OneToMany (mappedBy = "user")
    @JsonIgnore
    private List<Rental> rentals;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Discount> discounts;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Review> reviews;
}
