package com.example.jwtwithroles.repository;


import com.example.jwtwithroles.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

}
