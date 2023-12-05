package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddUserRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateUserRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetUserListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetUserResponse;
import com.example.rent_a_car_demo.services.concretes.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserManager userManager;

    @Autowired
    public UsersController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/getall")
    public List<GetUserListResponse> getAllUsers() {
        return userManager.getAllUsers();
    }

    @GetMapping("/get")
    public GetUserResponse getUserById(@RequestParam(value ="id") Integer id) {
        return userManager.getUserById(id);
    }


    @GetMapping("/byUsername/{username}")
    public GetUserResponse getUserByUsername(@PathVariable String username) {
        return userManager.getUserByUsername(username);
    }


    @PostMapping("/add")
    public String saveUser(@RequestBody AddUserRequest user) {


        return userManager.saveUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody UpdateUserRequest user) {



        return   userManager.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userManager.deleteUser(id);
    }

    @GetMapping("/gender/{gender}")
    public List<GetUserResponse> getUsersByGender(@PathVariable String gender) {
        return userManager.findByGender(gender);
    }
// Belirli tarihten sonraki doğum gününe göre kullanıcı bulma.
    @GetMapping("/birthdate/{birthDate}")
    public List<GetUserResponse> findByBirthDateAfter(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthDate) {
        Date birthDateAsDate = java.sql.Date.valueOf(birthDate);

        return userManager.findByBirthDateAfter(birthDateAsDate);
    }

    @GetMapping("/login")
    public List<GetUserResponse> getUsersByEmailAndPassword(
            @RequestParam String email,
            @RequestParam String password
    ) {
        return userManager.findByEmailAndPassword(email, password);
    }

    @DeleteMapping("/deleteByUsername/{username}")
    public String deleteUserByUsername(@PathVariable String username) {

    return this.userManager.deleteByUsername(username);
    }
}