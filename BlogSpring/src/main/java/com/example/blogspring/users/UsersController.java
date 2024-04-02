package com.example.blogspring.users;

import com.example.blogspring.users.dtos.CreateUserRequest;
import com.example.blogspring.users.dtos.UserResponse;
import com.example.blogspring.users.dtos.LoginUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
    @PostMapping("")
    ResponseEntity<UserResponse> signUpUser(@RequestBody CreateUserRequest createUserRequest){
        UserEntity savedUser = userService.createUser(createUserRequest);
        URI savedUserURI = URI.create("/users/"+savedUser.getId());
        return ResponseEntity.created(savedUserURI)
                .body(modelMapper.map(savedUser, UserResponse.class));
    }
    @PostMapping("/login")
    ResponseEntity<UserResponse> loginUser(@RequestBody LoginUserRequest loginUserRequest){
        UserEntity savedUser = userService.loginUser(loginUserRequest.getUsername(), loginUserRequest.getPassword());

        return ResponseEntity.ok(modelMapper.map(savedUser, UserResponse.class));
    }

    @ExceptionHandler({
            UserService.UserNotFoundException.class
    })
    ResponseEntity<String> handleUserNotFoundException(UserService.UserNotFoundException){
        return ResponseEntity.notFound().build();
    }
}
