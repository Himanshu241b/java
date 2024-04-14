package com.example.taskmanagerspring.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class JWTService {

    //TODO: move key to separate properties file (not in git)
    private static String JWT_KEY = "okwejfiowjfwnfihf309483of39t3nf9";
    private static final long EXPIRATION_TIME_MILLIS = 3600000; // 1 hour in milliseconds

    private static Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);

    public static String createJWT(Long userId){

        Date issuedAt = new Date();
        Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME_MILLIS); // Set expiry time

        return JWT.create()
                .withSubject(userId.toString())
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)  // TODO: set expiry
                .sign(algorithm);
    }

    public static Long retrieveUserId(String jwtString){

        var userIdDecoded = JWT.decode(jwtString);
        String userIdString = userIdDecoded.getSubject();
        Long userId = Long.parseLong(userIdString);
        return userId;
    }
}
