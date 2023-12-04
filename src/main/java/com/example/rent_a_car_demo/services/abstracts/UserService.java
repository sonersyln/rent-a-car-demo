package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.models.User;
import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddUserRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateUserRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetUserListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetUserResponse;

import java.util.Date;
import java.util.List;

public interface UserService {
    List<GetUserListResponse> getAllUsers();
    GetUserResponse getUserById(Integer id);
    GetUserResponse getUserByUsername(String username);
    String updateUser(int id, UpdateUserRequest user);
    String saveUser(AddUserRequest user);
    void deleteUser(Integer id);
    List<GetUserResponse> findByGender (String gender);
    List<GetUserResponse> findByBirthDateAfter(Date birthDate);
    List<GetUserResponse> findByEmailAndPassword(String email, String password);

}
