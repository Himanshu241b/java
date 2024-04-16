package com.example.jwtwithroles.service;



import com.example.jwtwithroles.dto.CreateUserDTO;
import com.example.jwtwithroles.dto.LoginUserDTO;
import com.example.jwtwithroles.entity.Role;
import com.example.jwtwithroles.entity.UserEntity;
import com.example.jwtwithroles.repository.RoleRepository;
import com.example.jwtwithroles.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
@Service
public class UserService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;
    public UserService(UsersRepository usersRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
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

    public UserEntity addRole(String role, UserEntity user){

        UserEntity existingUser = usersRepository.getByEmail(user.getEmail());
        Role roleToAdd = roleRepository.findByRole(role);
        existingUser.getRoles().add(roleToAdd);
        return usersRepository.save(existingUser);

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
        if(createUserDTO.getRole().equals("admin")){
            Role role = roleRepository.findByRole(createUserDTO.getRole());
            newUser.getRoles().add(role);
        }
        else if(createUserDTO.getRole().equals("super_admin")){
            Role role = roleRepository.findByRole(createUserDTO.getRole());
            newUser.getRoles().add(role);
        }
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

    public Collection<Role> getUserRoles(Long userId) {
        UserEntity user = getUserById(userId);
        return user.getRoles();
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
