package com.example.bankingApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Zipcode {

    @Id
    private String zipcode;

    private String city;

    private String state;
}
