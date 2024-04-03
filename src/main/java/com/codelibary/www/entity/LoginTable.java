package com.codelibary.www.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class LoginTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginId;

	private String userName;

	private String password;

	private String role;

	@OneToOne
	private ClientEntity user;

	@OneToOne
	private MasterAdmin masterAdmin;

	@OneToOne(cascade = CascadeType.ALL)
	private Admin admin;

	// Add this field to LoginTable entity
	@Column(name = "reset_token")
	private String resetToken;

	@OneToOne
	private ClientUsers clientUser;

	public LoginTable() {
		super();
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public ClientEntity getUser() {
		return user;
	}

	public void setUser(ClientEntity user) {
		this.user = user;
	}

	public MasterAdmin getMasterAdmin() {
		return masterAdmin;
	}

	public void setMasterAdmin(MasterAdmin masterAdmin) {
		this.masterAdmin = masterAdmin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public ClientUsers getClientUser() {
		return clientUser;
	}

	public void setClientUser(ClientUsers clientUser) {
		this.clientUser = clientUser;
	}

	public LoginTable(Long loginId, String userName, String password, String role, ClientEntity user,
			MasterAdmin masterAdmin, Admin admin, String resetToken, ClientUsers clientUser) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.user = user;
		this.masterAdmin = masterAdmin;
		this.admin = admin;
		this.resetToken = resetToken;
		this.clientUser = clientUser;
	}



	
	
}