package com.example.jwtwithroles.entity;


import jakarta.persistence.*;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleId;
	
	private String role;
	
	

	public Role() {
		super();
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
}