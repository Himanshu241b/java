package com.example.bankingApplication.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.bankingApplication.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
public class JWTService {

    //TODO: move key to eparate properties file (not in git)

    private static String JWT_KEY = "slkfjewofjowifwoi409u34jr43ut3oi4jtfoi3j";
    private static final long EXPIRATION_TIME_MILLIS = 3600000; // 1 hour in milliseconds

    private static Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);

    public static String createJWT(Long userId, Set<Role> roles){

        Date issuedAt = new Date();
        Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME_MILLIS); // Set expiry time

        List<String> roleNames = roles.stream()
                .map(Role::getRole).collect(Collectors.toList());

        return JWT.create()
                .withSubject(userId.toString())
                .withClaim("roles", roleNames)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .sign(algorithm);
    }

    public static DecodedJWT retrieveJWT(String jwtString){

        return JWT.require(algorithm)
                .build()
                .verify(jwtString);
    }

    public static Long retrieveUserId(String jwtString){
        DecodedJWT jwt = retrieveJWT(jwtString);
        String userIdString = jwt.getSubject();
        return Long.parseLong(userIdString);
    }

    public static List<String> retrieveRoles(String jwtString) {
        DecodedJWT jwt = retrieveJWT(jwtString);
        Claim rolesClaim = jwt.getClaim("roles");
        return rolesClaim.asList(String.class);
    }
}
