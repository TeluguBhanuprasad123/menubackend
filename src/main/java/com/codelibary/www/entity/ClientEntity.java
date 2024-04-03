package com.codelibary.www.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ClientEntity {

 @Id
 @Column(name = "bussiness_id")
 private  String bussiness_id;

 
 	// firm 
	private  String bussinessName; // 
	private long pinCode; //
	private String gstInNumber; //
	@Column(name = "address")
	private String address; //
	@Column(name = "city")
	private String city; //
	@Column(name = "state")
	private String state; //
	@Column(name = "country")
	private String country; //
	private String location; //
	
	@Column(columnDefinition = "longblob")
	private byte[] qrcode;

	// primary contact name
	@Column(name = "user_Name")
	private String userName; //
	// primary contact mobile number
	@Column(name = "contact_Number")
	private Long contactNumber; //
	// primary contact mobile number
	@Column(name = "alternate_Number")
	private Long alternateNumber; //
	// primary contact email
	@Column(name = "email",unique = true)
	private String email; //
	
	@Column(name = "manager_First_Name")
	private String managerFirstName;
	
	@Column(name = "manager_Last_Name")
	private String managerLastName;
	
	@Column(name = "manager_Number")
	private long managerNumber;
	
	@Column(name = "bank_Name")
	private String bankName;
	
	@Column(name = "bankBranch")
	private String bankBranch;
	
	@Column(name = "ifscCode")
	private String ifscCode;
	
	@Column(name = "bank_Type")
	private String bankType;
	
	@Column(name = "account_Number")
	private String accountNumber;
	
	@Column(name = "type_Of_User")
	private String typeOfUser;
	
	@Column(name = "number_Of_Days")
	private long numberOfDays; 
	
	
	
	
//@JsonManagedReference
//	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
//	private  LoginTable loginTable;


	
	
	@Column(name = "password")
	private String password; //
	@Column(name = "confirm_Password")
	private String confirmPassword; //
	


	
	private String role; //




	@Column(columnDefinition = "longblob")
	private byte[] attachments;

private long views;


	@JsonManagedReference
	@OneToMany(mappedBy ="clientEnity",cascade = CascadeType.ALL,orphanRemoval = true )
	List<ClientUsers> clientUsers = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "clientEnitys", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Departments> departments = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "clientEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Categories> categories = new ArrayList<>();

	@ManyToOne
	@JsonBackReference
	private Admin adminId;

	public ClientEntity() {
		super();
	}

	public ClientEntity(String bussiness_id, String bussinessName, long pinCode, String gstInNumber, String address,
			String city, String state, String country, String location, byte[] qrcode, String userName,
			Long contactNumber, Long alternateNumber, String email, String managerFirstName, String managerLastName,
			long managerNumber, String bankName, String bankBranch, String ifscCode, String bankType,
			String accountNumber, String typeOfUser, long numberOfDays, String password, String confirmPassword,
			String role, byte[] attachments, long views, List<ClientUsers> clientUsers, List<Departments> departments,
			List<Categories> categories, Admin adminId) {
		super();
		this.bussiness_id = bussiness_id;
		this.bussinessName = bussinessName;
		this.pinCode = pinCode;
		this.gstInNumber = gstInNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.location = location;
		this.qrcode = qrcode;
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.alternateNumber = alternateNumber;
		this.email = email;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.managerNumber = managerNumber;
		this.bankName = bankName;
		this.bankBranch = bankBranch;
		this.ifscCode = ifscCode;
		this.bankType = bankType;
		this.accountNumber = accountNumber;
		this.typeOfUser = typeOfUser;
		this.numberOfDays = numberOfDays;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
		this.attachments = attachments;
		this.views = views;
		this.clientUsers = clientUsers;
		this.departments = departments;
		this.categories = categories;
		this.adminId = adminId;
	}

	public String getBussiness_id() {
		return bussiness_id;
	}

	public void setBussiness_id(String bussiness_id) {
		this.bussiness_id = bussiness_id;
	}

	public String getBussinessName() {
		return bussinessName;
	}

	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	public String getGstInNumber() {
		return gstInNumber;
	}

	public void setGstInNumber(String gstInNumber) {
		this.gstInNumber = gstInNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public byte[] getQrcode() {
		return qrcode;
	}

	public void setQrcode(byte[] qrcode) {
		this.qrcode = qrcode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Long getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(Long alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public long getManagerNumber() {
		return managerNumber;
	}

	public void setManagerNumber(long managerNumber) {
		this.managerNumber = managerNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	public long getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(long numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public byte[] getAttachments() {
		return attachments;
	}

	public void setAttachments(byte[] attachments) {
		this.attachments = attachments;
	}

	public long getViews() {
		return views;
	}

	public void setViews(long views) {
		this.views = views;
	}

	public List<ClientUsers> getClientUsers() {
		return clientUsers;
	}

	public void setClientUsers(List<ClientUsers> clientUsers) {
		this.clientUsers = clientUsers;
	}

	public List<Departments> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Departments> departments) {
		this.departments = departments;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	public Admin getAdminId() {
		return adminId;
	}

	public void setAdminId(Admin adminId) {
		this.adminId = adminId;
	}



}