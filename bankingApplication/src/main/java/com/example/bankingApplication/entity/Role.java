package com.example.bankingApplication.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="role")
public class Role {
	
	@Id
	private String role;

	
}