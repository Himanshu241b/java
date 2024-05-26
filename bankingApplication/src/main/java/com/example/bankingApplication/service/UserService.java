package com.example.bankingApplication.service;

import com.example.bankingApplication.dto.CreateUserDTO;
import com.example.bankingApplication.dto.LoginUserDTO;
import com.example.bankingApplication.entity.*;
import com.example.bankingApplication.repository.AddressRepository;
import com.example.bankingApplication.repository.RoleRepository;
import com.example.bankingApplication.repository.UserRepository;
import com.example.bankingApplication.repository.ZipcodeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

    private final UserRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    private final ZipcodeRepository zipcodeRepository;

    private final AddressRepository addressRepository;

    private final RoleRepository roleRepository;
    public UserService(UserRepository usersRepository, RoleRepository roleRepository, ZipcodeRepository zipcodeRepository, AddressRepository addressRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressRepository = addressRepository;
        this.zipcodeRepository = zipcodeRepository;
        this.roleRepository = roleRepository;
    }

    public User getUserById(Long userId) throws EntityNotFoundException{
        User user = usersRepository.getById(userId);
        if(user == null){
            throw new EntityNotFoundException("User " + userId + " not found");
        }
        else{
            return user;
        }
    }


    public User registerUser(CreateUserDTO createUserDTO){
        // check if email already exist in database
        User user = usersRepository.getByEmail(createUserDTO.getEmail());
        if(user != null){
            throw new EmailAlreadyExistsException(createUserDTO.getEmail());
        }

        // if email doesn't exist create a new user
        User newUser = new User();
        newUser.setEmail(createUserDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        newUser.setName(createUserDTO.getName());
        newUser.setContact(createUserDTO.getContact());
        newUser.setAdhaarNumber(createUserDTO.getAdhaarNumber());
        newUser.setPanNumber(createUserDTO.getPanNumber());
        //create an address entity
        Address address = new Address();
        address.setPropertyNumber(createUserDTO.getPropertyNumber());
        if(createUserDTO.getAddressType().equals("PERMANENT"))
            address.setAddressType(AddressType.PERMANENT);
        else
            address.setAddressType(AddressType.TEMPORARY);
        address.setStreetNumber(createUserDTO.getStreetNumber());
        address.setCountry(createUserDTO.getCountry());
        // first check if zipcode exists in db
        Zipcode zipcode = zipcodeRepository.findById(createUserDTO.getZipcode()).orElse(null);
        if(zipcode != null){
            address.setZipcode(zipcode);
        }
        else if (zipcode == null){
            Zipcode newZipcode = new Zipcode();
            newZipcode.setZipcode(createUserDTO.getZipcode());
            newZipcode.setCity(createUserDTO.getCity());
            newZipcode.setState(createUserDTO.getState());
            zipcodeRepository.save(newZipcode);
            address.setZipcode(newZipcode);
        }

        addressRepository.save(address);
        newUser.getAddresses().add(address);

        if(createUserDTO.getRole().equals("manager")) {
            Role role = roleRepository.findByRole(createUserDTO.getRole());
            newUser.getRoles().add(role);
        }

        return usersRepository.save(newUser);
    }

    public User loginUser(LoginUserDTO loginUserDTO) throws EntityNotFoundException, WrongPasswordCredentialsException{
        User loggedInUser = usersRepository.getByEmail(loginUserDTO.getEmail());
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
