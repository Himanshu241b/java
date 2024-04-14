package com.example.blogspring.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class UsersRepositoryTests {
    @Autowired
    UsersRepository usersRepository;

    @Test
    @Order(1)
    void can_create_users(){
        var user = UserEntity.builder()
                .username("himanshu")
                .email("himanshu.chaudhary@avisoft.io")
                .build();
        usersRepository.save(user);
    }

    //every test runs on a fresh database instance so we need to add the user againg in can_find_users method
    @Test
    @Order(2)
    void can_find_users(){
        var user = UserEntity.builder()
                .username("himanshu")
                .email("himanshu.chaudhary@avisoft.io")
                .build();
        usersRepository.save(user);
        var findUser = usersRepository.findAll();
        assert findUser.size() == 1;
    }
}
