package com.example.bankingApplication.repository;

import com.example.bankingApplication.entity.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipcodeRepository extends JpaRepository<Zipcode, String> {
}
