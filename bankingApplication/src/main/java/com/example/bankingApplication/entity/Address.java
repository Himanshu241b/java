package com.example.bankingApplication.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private int propertyNumber;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    private int streetNumber;

    @ManyToOne
    @JoinColumn(name = "zipcode", referencedColumnName = "zipcode")
    private Zipcode zipcode;

    private String country;

}
