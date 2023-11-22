package com.example.rent_a_car_demo.services;

import com.example.rent_a_car_demo.dtos.requests.AddUserRequest;
import com.example.rent_a_car_demo.dtos.requests.UpdateUserRequest;
import com.example.rent_a_car_demo.dtos.responses.GetBrandListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetUserListResponse;
import com.example.rent_a_car_demo.dtos.responses.GetUserResponse;
import com.example.rent_a_car_demo.models.Brand;
import com.example.rent_a_car_demo.models.User;
import com.example.rent_a_car_demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<GetUserListResponse> getAllUsers() {
        List<User> brands = this.userRepository.findAll();
        List<GetUserListResponse> getUserListResponses = new ArrayList<>();
        for (User user : brands) {
            GetUserListResponse getUserListResponse = new GetUserListResponse();

            getUserListResponse.setFirstName(user.getFirstName());
            getUserListResponse.setLastName(user.getLastName());
            getUserListResponse.setUsername(user.getUsername());
            getUserListResponse.setEmail(user.getEmail());
            getUserListResponse.setPhone(user.getPhone());
            getUserListResponse.setGender(user.getGender());
            getUserListResponse.setBirthDate(user.getBirthDate());

            getUserListResponses.add(getUserListResponse);

        }
        return getUserListResponses;
    }

    public GetUserResponse getUserById(Integer id) {
        User user= this.userRepository.getReferenceById(id);
        GetUserResponse getUserResponse = new GetUserResponse();

        getUserResponse.setFirstName(user.getFirstName());
        getUserResponse.setLastName(user.getLastName());
        getUserResponse.setUsername(user.getUsername());
        getUserResponse.setEmail(user.getEmail());
        getUserResponse.setPhone(user.getPhone());
        getUserResponse.setGender(user.getGender());
        getUserResponse.setBirthDate(user.getBirthDate());

        return getUserResponse;
    }

    public GetUserResponse getUserByUsername(String username) {


        User user= this.userRepository.findByUsername(username);
        GetUserResponse getUserResponse = new GetUserResponse();

        getUserResponse.setFirstName(user.getFirstName());
        getUserResponse.setLastName(user.getLastName());
        getUserResponse.setUsername(user.getUsername());
        getUserResponse.setEmail(user.getEmail());
        getUserResponse.setPhone(user.getPhone());
        getUserResponse.setGender(user.getGender());
        getUserResponse.setBirthDate(user.getBirthDate());

        return getUserResponse;
    }
    public String updateUser(int id, UpdateUserRequest user) {

        User getUser= this.userRepository.getReferenceById(id);



        getUser.setFirstName(user.getFirstName());
        getUser.setLastName(user.getLastName());
        getUser.setUsername(user.getUsername());
        getUser.setEmail(user.getEmail());
        getUser.setPhone(user.getPhone());
        getUser.setGender(user.getGender());
        getUser.setBirthDate(user.getBirthDate());

        this.userRepository.save(getUser);

        return "Transaction successful";
    }

    public String saveUser(AddUserRequest user) {
        User createdUser = new User();
        createdUser.setFirstName(user.getFirstName());
        createdUser.setLastName(user.getLastName());
        createdUser.setUsername(user.getUsername());
        createdUser.setEmail(user.getEmail());
        createdUser.setPhone(user.getPhone());
        createdUser.setGender(user.getGender());
        createdUser.setBirthDate(user.getBirthDate());

        this.userRepository.save(createdUser);

        return  "Transaction successful";
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
