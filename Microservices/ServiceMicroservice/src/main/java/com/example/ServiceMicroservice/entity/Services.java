package com.example.ServiceMicroservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private Long userId;

    private String serviceName;
}
