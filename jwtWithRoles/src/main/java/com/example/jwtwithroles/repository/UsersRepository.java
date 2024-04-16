package com.example.jwtwithroles.repository;


import com.example.jwtwithroles.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {
    UserEntity getByEmail(String email);

}
