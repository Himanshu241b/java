package com.example.blogspring.users;

import com.example.blogspring.users.dtos.CreateUserRequest;
import com.example.blogspring.users.dtos.UserResponse;
import com.example.blogspring.users.dtos.LoginUserRequest;
import com.example.blogspring.common.dtos.ErrorResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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
    ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception exception){
        String message;
        HttpStatus status;
        if(exception instanceof UserService.UserNotFoundException){
            message = exception.getMessage();
            status = HttpStatus.NOT_FOUND;
        }
        else{
            message = "something went wrong";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(message)
                .build();
        return ResponseEntity.status(status).body(errorResponse);
    }
}
