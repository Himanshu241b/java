package com.example.BasicSecurityAuth.Service;

import com.example.BasicSecurityAuth.Repository.UserRepository;
import com.example.BasicSecurityAuth.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class UserService {

    UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());

        return userRepository.save(newUser);
    }
}
