package com.example.jwtwithroles.security;


import com.example.jwtwithroles.service.JWTService;
import com.example.jwtwithroles.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


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
            var roles = userService.getUserRoles(userId);
            jwtAuthentication.userEntity = userEntity;
            jwtAuthentication.setAuthenticated(true);

            // Set roles in the JWTAuthentication

            JWTAuthentication tokenProvider = new JWTAuthentication(jwt);
            Collection<? extends GrantedAuthority> authorities = tokenProvider.getAuthorities();

            return jwtAuthentication;
        }
        throw new IllegalAccessError("Cannot authenticate with non JWT-Authentication");
    }
}
