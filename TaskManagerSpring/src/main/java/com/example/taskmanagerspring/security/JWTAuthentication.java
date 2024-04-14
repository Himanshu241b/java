package com.example.taskmanagerspring.security;


import com.example.taskmanagerspring.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JWTAuthentication implements Authentication {

   String jwt;
   UserEntity userEntity;

    public JWTAuthentication(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
