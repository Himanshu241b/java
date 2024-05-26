package com.example.bankingApplication.repository;


import com.example.bankingApplication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
     Role findByRole(String role);
}
