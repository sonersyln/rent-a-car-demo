package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.services.dtos.requests.addRequests.AddUserRequest;
import com.example.rent_a_car_demo.services.dtos.requests.updateRequests.UpdateUserRequest;
import com.example.rent_a_car_demo.services.dtos.responses.getListResponses.GetUserListResponse;
import com.example.rent_a_car_demo.services.dtos.responses.getResponses.GetUserResponse;
import com.example.rent_a_car_demo.models.User;
import com.example.rent_a_car_demo.repositories.UserRepository;
import com.example.rent_a_car_demo.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;


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

    @Override
    public List<GetUserResponse> findByGender(String gender) {
        List<User> users = userRepository.findByGender(gender);
        List<GetUserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
            GetUserResponse response = new GetUserResponse();
            response.setGender(user.getGender());
            response.setUsername(user.getUsername());
            response.setEmail(user.getEmail());
            response.setPhone(user.getPhone());
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setBirthDate(user.getBirthDate());

            userResponses.add(response);
        }

        return userResponses;
    }

    @Override
    public List<GetUserResponse> findByBirthDateAfter(Date birthDate) {
        return this.userRepository.findByBirthDateAfter(birthDate);
    }

    @Override
    public List<GetUserResponse> findByEmailAndPassword(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email, password);
    }


}
