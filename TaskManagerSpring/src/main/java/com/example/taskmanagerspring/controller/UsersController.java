package com.example.taskmanagerspring.controller;

import com.example.taskmanagerspring.dto.*;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.service.JWTService;
import com.example.taskmanagerspring.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final JWTService jwtService;
    public UsersController(UserService userService, JWTService jwtService, ModelMapper modelMapper) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<UserResponse> registerUser(@RequestBody CreateUserDTO createUserDTO) throws UserService.EmailAlreadyExistsException {
        UserEntity newUser = userService.registerUser(createUserDTO);
        URI newUserUri = URI.create("/users/"+newUser.getUserId());
        UserResponse createUserResponseDTO = modelMapper.map(newUser, UserResponse.class);
        createUserResponseDTO.setToken(
                JWTService.createJWT(newUser.getUserId()));
        return ResponseEntity.created(newUserUri).body(createUserResponseDTO);
    }

    @GetMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginUserDTO loginUserDTO)throws EntityNotFoundException, UserService.WrongPasswordCredentialsException {
        UserEntity loggedInUser = userService.loginUser(loginUserDTO);
        UserResponse userResponse = modelMapper.map(loggedInUser, UserResponse.class);
        userResponse.setToken(
                JWTService.createJWT(loggedInUser.getUserId()));
        return ResponseEntity.ok(userResponse);
    }

    @ExceptionHandler(
            {UserService.WrongPasswordCredentialsException.class
                    , EntityNotFoundException.class
                    , UserService.EmailAlreadyExistsException.class

            }
    )
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception exception){
        String message;
        HttpStatus status;
        if(exception instanceof EntityNotFoundException){
            message = exception.getMessage();
            status = HttpStatus.NOT_FOUND;
        }
        else if(exception instanceof UserService.WrongPasswordCredentialsException) {
            message = exception.getMessage();
            status = HttpStatus.BAD_REQUEST;
        }
        else if (exception instanceof UserService.EmailAlreadyExistsException){
            message = exception.getMessage();
            status = HttpStatus.BAD_REQUEST;
        }
        else{
            message = "something went wrong";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        ErrorResponseDTO errorResponse = ErrorResponseDTO.builder()
                .message(message)
                .build();
        return ResponseEntity.status(status).body(errorResponse);
    }
}
