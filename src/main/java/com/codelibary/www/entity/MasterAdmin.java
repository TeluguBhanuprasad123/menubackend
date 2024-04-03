package com.codelibary.www.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MasterAdmin {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long masterId;

	private String masterName;

	private String email;

	private String password;

	private String role;

	public Long getMasterId() {
		return masterId;
	}

	public void setMasterId(Long masterId) {
		this.masterId = masterId;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public MasterAdmin(Long masterId, String masterName, String email, String password, String role) {
		super();
		this.masterId = masterId;
		this.masterName = masterName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public MasterAdmin() {
		super();
		
	}
	
}
