package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.AddUserRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateUserRequest;
import com.example.rent_a_car_demo.dtos.responses.GetUserListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetUserResponse;
import com.example.rent_a_car_demo.models.User;
import com.example.rent_a_car_demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public List<GetUserListResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get")
    public GetUserResponse getUserById(@RequestParam(value ="id") Integer id) {
        return userService.getUserById(id);
    }


    @GetMapping("/byUsername/{username}")
    public GetUserResponse getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }


    @PostMapping("/add")
    public String saveUser(@RequestBody AddUserRequest user) {


        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody UpdateUserRequest user) {



        return   userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}