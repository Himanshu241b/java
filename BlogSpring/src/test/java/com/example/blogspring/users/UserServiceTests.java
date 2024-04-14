package com.example.blogspring.users;

import com.example.blogspring.users.dtos.CreateUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTests {

    @Autowired
    UserService userService;
    @Test
    void can_create_users(){
        var user = userService.createUser(new CreateUserRequest(
                "john",
                "john123",
                "john@gmail.com"
        ));
        Assertions.assertNotNull(user);
        Assertions.assertEquals("john", user.getUsername());

    }
}
