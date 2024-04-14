package com.example.taskmanagerspring.security;

import com.example.taskmanagerspring.service.JWTService;
import com.example.taskmanagerspring.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


public class JWTAuthenticationManager implements AuthenticationManager {

    private final JWTService jwtService;
    private final UserService userService;

    public JWTAuthenticationManager(JWTService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException , IllegalAccessError{
        if(authentication instanceof JWTAuthentication){
            var jwtAuthentication = (JWTAuthentication) authentication;
            var jwt = jwtAuthentication.getCredentials();
            var userId =jwtService.retrieveUserId(jwt);
            var userEntity = userService.getUserById(userId);

            jwtAuthentication.userEntity = userEntity;
            jwtAuthentication.setAuthenticated(true);


            return jwtAuthentication;
        }
        throw new IllegalAccessError("Cannot authenticate with non JWT-Authentication");
    }
}
