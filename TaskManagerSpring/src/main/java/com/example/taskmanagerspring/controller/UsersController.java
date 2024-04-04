package com.example.taskmanagerspring.controller;

import com.example.taskmanagerspring.dto.CreateUserDTO;
import com.example.taskmanagerspring.dto.ErrorResponseDTO;
import com.example.taskmanagerspring.dto.LoginResponseDTO;
import com.example.taskmanagerspring.dto.LoginUserDTO;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("")
    public ResponseEntity<UserEntity> registerUser(@RequestBody CreateUserDTO createUserDTO){
        UserEntity newUser = userService.registerUser(createUserDTO);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginUserDTO loginUserDTO)throws EntityNotFoundException, UserService.WrongPasswordCredentialsException {
        LoginResponseDTO loginResponseDTO =  userService.loginUser(loginUserDTO);
        return ResponseEntity.ok(loginResponseDTO);
    }

    @ExceptionHandler(
            {UserService.WrongPasswordCredentialsException.class
                    , EntityNotFoundException.class
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
