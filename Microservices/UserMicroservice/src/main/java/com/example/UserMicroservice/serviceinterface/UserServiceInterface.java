package com.example.UserMicroservice.serviceinterface;

import com.example.UserMicroservice.entity.User;

public interface UserServiceInterface {

    public User getUserById(Long userId);

    public User addUser(User user);
}
