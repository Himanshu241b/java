package com.example.taskmanagerspring.service;


import com.example.taskmanagerspring.dto.CreateUserDTO;
import com.example.taskmanagerspring.dto.LoginUserDTO;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;
    public UserService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
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
        // check if email already exist in database
        UserEntity user = usersRepository.getByEmail(createUserDTO.getEmail());
        if(user != null){
            throw new EmailAlreadyExistsException(createUserDTO.getEmail());
        }
        // if email doesn't exist create a new user
        UserEntity newUser = new UserEntity();
        newUser.setUsername(createUserDTO.getUsername());
        newUser.setEmail(createUserDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));

        return usersRepository.save(newUser);
    }

    public UserEntity loginUser(LoginUserDTO loginUserDTO) throws EntityNotFoundException, WrongPasswordCredentialsException{
        UserEntity loggedInUser = usersRepository.getByEmail(loginUserDTO.getEmail());
        if(loggedInUser == null){
            throw new EntityNotFoundException("User with email " + loginUserDTO.getEmail()+" not found");
        }
        if(passwordEncoder.matches(loginUserDTO.getPassword(), loggedInUser.getPassword())){
                return loggedInUser;
        }
        else{
            throw new WrongPasswordCredentialsException(loggedInUser.getEmail());
        }

    }


    public static class WrongPasswordCredentialsException extends IllegalAccessException{
        public WrongPasswordCredentialsException(String email){
            super("Wrong password for " + email);
        }
    }

    public static class EmailAlreadyExistsException extends RuntimeException{
        public EmailAlreadyExistsException(String email){
            super(email+ " already exists");
        }
    }
}
