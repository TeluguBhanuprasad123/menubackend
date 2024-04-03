package com.codelibary.www.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="clientuser")
public class ClientUsers {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cuserid;

	private String cname;

	private String contactNumber;
	
	private String specialization;

	private String dob;

	private String email;

	private String role;

	private String address;

	private String adharNumber;

	private String panNumber;

	private String password;

	@Column(columnDefinition = "longblob")
	private byte[] clogo;

	private int age;

	private String gender;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)

	private ClientEntity clientEnity;

	
	public long getCuserid() {
		return cuserid;
	}

	public void setCuserid(long cuserid) {
		this.cuserid = cuserid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getClogo() {
		return clogo;
	}

	public void setClogo(byte[] clogo) {
		this.clogo = clogo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ClientEntity getClientEnity() {
		return clientEnity;
	}

	public void setClientEnity(ClientEntity clientEnity) {
		this.clientEnity = clientEnity;
	}

	public ClientUsers(long cuserid, String cname, String contactNumber, String specialization, String dob,
			String email, String role, String address, String adharNumber, String panNumber, String password,
			byte[] clogo, int age, String gender, ClientEntity clientEnity) {
		super();
		this.cuserid = cuserid;
		this.cname = cname;
		this.contactNumber = contactNumber;
		this.specialization = specialization;
		this.dob = dob;
		this.email = email;
		this.role = role;
		this.address = address;
		this.adharNumber = adharNumber;
		this.panNumber = panNumber;
		this.password = password;
		this.clogo = clogo;
		this.age = age;
		this.gender = gender;
		this.clientEnity = clientEnity;
	}

	public ClientUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
