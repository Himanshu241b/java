package com.example.BasicSecurityAuth.Controller;

import com.example.BasicSecurityAuth.Repository.UserRepository;
import com.example.BasicSecurityAuth.Service.UserService;
import com.example.BasicSecurityAuth.model.User;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


public class UserControllerActions {

    UserRepository userRepository;

    UserService userService;

    UserControllerActions(UserService userService,UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.saveUser(user);

        return ResponseEntity.ok(newUser);
    }



}
