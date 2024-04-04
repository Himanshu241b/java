package com.example.taskmanagerspring.service;


import com.example.taskmanagerspring.dto.CreateUserDTO;
import com.example.taskmanagerspring.dto.LoginResponseDTO;
import com.example.taskmanagerspring.dto.LoginUserDTO;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserEntity getUserById(Long userId) throws EntityNotFoundException{
        UserEntity user = usersRepository.getById(userId);
        if(user == null){
            throw new EntityNotFoundException("User " + userId + " not found");
        }
        else{
            return user;
        }
    }
    public UserEntity registerUser(CreateUserDTO createUserDTO){
        UserEntity newUser = new UserEntity();
        newUser.setUsername(createUserDTO.getUsername());
        newUser.setEmail(createUserDTO.getEmail());
        newUser.setPassword(createUserDTO.getPassword());

        return usersRepository.save(newUser);
    }

    public LoginResponseDTO loginUser(LoginUserDTO loginUserDTO) throws EntityNotFoundException, WrongPasswordCredentialsException{
        UserEntity user = usersRepository.getByEmail(loginUserDTO.getEmail());
        if(user == null){
            throw new EntityNotFoundException("User with email " + loginUserDTO.getEmail()+" not found");
        }
        if(user.getPassword().equals(loginUserDTO.getPassword())){
            // Todo: generate token here
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
            loginResponseDTO.setUserId(user.getUserId());
            loginResponseDTO.setEmail(loginUserDTO.getEmail());
            loginResponseDTO.setPassword(loginUserDTO.getPassword());
            return loginResponseDTO;
        }
        else{
            throw new WrongPasswordCredentialsException(user.getEmail());
        }

    }

    public static class WrongPasswordCredentialsException extends RuntimeException{
        public WrongPasswordCredentialsException(String email){
            super("Wrong password for " + email);
        }
    }
}
