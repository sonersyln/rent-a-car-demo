package com.example.rent_a_car_demo.models;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddEmployeeRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends AddEmployeeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column (name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column (name = "username", nullable = false, length = 50)
    private String username;

    @Column (name = "password", nullable = false, length = 20)
    private String password;

    @Column (name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column (name = "role", nullable = false, length = 30)
    private String role;

    @Column (name = "phone", nullable = false, length = 11)
    private String phone;

    @Column (name = "gender", nullable = false, length = 10)
    private String gender;

    @Column (name = "birth_date", nullable = false)
    private Date birthDate;

    @OneToMany (mappedBy = "employee")
    @JsonIgnore
    private List<Rental> rentals;
}
