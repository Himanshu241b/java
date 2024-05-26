package com.example.UserMicroservice.Controller;

import com.example.UserMicroservice.dtos.UserByIdResponse;
import com.example.UserMicroservice.entity.User;
import com.example.UserMicroservice.serviceimpl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private final RestTemplate restTemplate;
    private final UserServiceImpl userServiceImpl;

    UserController(UserServiceImpl userServiceImpl, RestTemplate restTemplate) {
        this.userServiceImpl = userServiceImpl;
        this.restTemplate = restTemplate;
    }
    @GetMapping("")
    public ResponseEntity<UserByIdResponse> getuserById(@RequestParam("userId")Long userId) {

        User userFoundById =  userServiceImpl.getUserById(userId);

        String url = "http://localhost:7777/service/user/"+userId;
        List<?> serviceListOfUser =  restTemplate.getForObject(url, List.class);

        UserByIdResponse userByIdResponse = new UserByIdResponse();
        userByIdResponse.setUserId(userFoundById.getUserId());
        userByIdResponse.setName(userFoundById.getName());
        userByIdResponse.setServicesList(serviceListOfUser);

        return ResponseEntity.ok(userByIdResponse);



    }

    @PostMapping("")
    public User addUser(@RequestBody User user) {
        return userServiceImpl.addUser(user);
    }

//    @PutMapping("")
//    public User addService()

}
