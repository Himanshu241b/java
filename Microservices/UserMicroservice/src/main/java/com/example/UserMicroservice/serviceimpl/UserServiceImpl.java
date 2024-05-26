package com.example.UserMicroservice.serviceimpl;

import com.example.UserMicroservice.entity.User;
import com.example.UserMicroservice.repository.UserRepository;
import com.example.UserMicroservice.serviceinterface.UserServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User addUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        return userRepository.save(newUser);
    }
}
