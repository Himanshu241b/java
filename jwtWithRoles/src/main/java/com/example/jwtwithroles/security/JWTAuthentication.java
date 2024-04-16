package com.example.jwtwithroles.security;


import com.example.jwtwithroles.entity.UserEntity;
import com.example.jwtwithroles.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthentication implements Authentication {

   String jwt;
   UserEntity userEntity;

   @Autowired
    JWTService jwtService;

    public JWTAuthentication(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // Extract roles from JWT claims
        List<String> roles = jwtService.retrieveRoles(jwt);
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("Role_"+role))// prefix role is a convention in spring security
                .collect(Collectors.toList());
    }

    /**
     * Returns credentials of the {Authentication} request
     * for eg. password, bearer token or cookie
     * @return jwt token in this case
     */
    @Override
    public String getCredentials() {
        return jwt;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    /**
     * Returns the principal of the {Authentication} request
     * Principal is entity that is being authenticated
     * In this case its the User.
     * @return userEntity in this case
     */
    @Override
    public UserEntity getPrincipal() {
        return userEntity;
    }

    @Override
    public boolean isAuthenticated() {
        return (userEntity != null);
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }

}
