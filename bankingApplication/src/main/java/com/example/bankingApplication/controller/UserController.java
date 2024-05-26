package com.example.bankingApplication.controller;

import com.example.bankingApplication.dto.*;
import com.example.bankingApplication.entity.User;
import com.example.bankingApplication.service.EmailService;
import com.example.bankingApplication.service.JWTService;
import com.example.bankingApplication.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
@Transactional
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final EmailService emailService;
    public UserController(UserService userService, EmailService emailService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
    }

    @PostMapping("")
    public ResponseEntity<CreateUserResponseDTO> registerUser(@RequestBody CreateUserDTO createUserDTO) throws UserService.EmailAlreadyExistsException {
        User newUser = userService.registerUser(createUserDTO);
        String emailSuccessResponse = emailService.sendEmail("himanshu.chaudhary@avisoft.io", "Account creation request.", "<html><body><p>Name: "+newUser.getName()+"</p><p>contact: "+newUser.getContact()+"</p><p>Adhaar: "+newUser.getAdhaarNumber()+"</p><p>Pan Number: "+newUser.getPanNumber()+"</p><p>email: "+createUserDTO.getEmail()+"</p><p>AccountType: "+createUserDTO.getAccountType()+"</p><p>city: "+createUserDTO.getCity()+"</p><p>zipcode: "+createUserDTO.getZipcode()+"</p><p>country: "+createUserDTO.getCountry()+"</p><a href='http://localhost:5555/account/create/"+newUser.getUserId()+"/accountType/"+createUserDTO.getAccountType()+"'>Create Account</a></body></html>");
        CreateUserResponseDTO createUserResponseDTO = modelMapper.map(newUser, CreateUserResponseDTO.class);
        createUserResponseDTO.setMessage(emailSuccessResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponseDTO> loginUser(@RequestBody LoginUserDTO loginUserDTO)throws EntityNotFoundException, UserService.WrongPasswordCredentialsException {
        User loggedInUser = userService.loginUser(loginUserDTO);
        LoginUserResponseDTO loginUserResponseDTO = modelMapper.map(loggedInUser, LoginUserResponseDTO.class);
        loginUserResponseDTO.setToken(
                JWTService.createJWT(loggedInUser.getUserId(), loggedInUser.getRoles()));
        return ResponseEntity.ok(loginUserResponseDTO);
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
