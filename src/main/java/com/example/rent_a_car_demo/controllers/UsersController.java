package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddUserRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateUserRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetUserListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetUserResponse;
import com.example.rent_a_car_demo.services.concretes.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}