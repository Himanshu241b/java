package com.example.taskmanagerspring.security;

import com.example.taskmanagerspring.service.JWTService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JWTSecurityTests {

    JWTService jwtService =  new JWTService();

    @Test
    void canCreateJWTFromUserId(){
        var jwt = jwtService.createJWT(1L);
        assertNotNull(jwt);
    }
}
