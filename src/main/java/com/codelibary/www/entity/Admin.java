package com.codelibary.www.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.codelibary.www.enums.AdminSubRole;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminId;
	
	@Column(unique = true)
	private String adminName;

	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] attcatment1;
	private String firstName;
	private String lastName;
	private Long contactNumber;
	private String email;
	private String state;
	private String country;
	private String password;
	private String address;
	@Enumerated(EnumType.STRING)
	private AdminSubRole adminSubrole;
	private Date createdBy;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "admin_features",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private Set<Feature> features = new HashSet<>();
	
	
	//////////////////////////////////////////////
	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] attcatment2;

	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] attcatment3;
	
	private String gender;
     
	private String dropdown;
	

	private String confirmPassword;

	private Long alternateNumber;

	private String city;


	private String role;
	
	private String urlRoute;

	private String dob;

	private int age;
	
	private String listCheckbox;


	
	@OneToMany(mappedBy = "adminId",cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonManagedReference
	private List<ClientEntity>clientEntityList = new ArrayList<>();


	public Admin() {
	}


	public Admin(Long adminId, String adminName, byte[] attcatment1, String firstName, String lastName,
			Long contactNumber, String email, String state, String country, String password, String address,
			AdminSubRole adminSubrole, Date createdBy, Set<Feature> features, byte[] attcatment2, byte[] attcatment3,
			String gender, String dropdown, String confirmPassword, Long alternateNumber, String city, String role,
			String urlRoute, String dob, int age, String listCheckbox, List<ClientEntity> clientEntityList) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.attcatment1 = attcatment1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.state = state;
		this.country = country;
		this.password = password;
		this.address = address;
		this.adminSubrole = adminSubrole;
		this.createdBy = createdBy;
		this.features = features;
		this.attcatment2 = attcatment2;
		this.attcatment3 = attcatment3;
		this.gender = gender;
		this.dropdown = dropdown;
		this.confirmPassword = confirmPassword;
		this.alternateNumber = alternateNumber;
		this.city = city;
		this.role = role;
		this.urlRoute = urlRoute;
		this.dob = dob;
		this.age = age;
		this.listCheckbox = listCheckbox;
		this.clientEntityList = clientEntityList;
	}


	public Long getAdminId() {
		return adminId;
	}


	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public byte[] getAttcatment1() {
		return attcatment1;
	}


	public void setAttcatment1(byte[] attcatment1) {
		this.attcatment1 = attcatment1;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public AdminSubRole getAdminSubrole() {
		return adminSubrole;
	}


	public void setAdminSubrole(AdminSubRole adminSubrole) {
		this.adminSubrole = adminSubrole;
	}


	public Date getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}


	public Set<Feature> getFeatures() {
		return features;
	}


	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}


	public byte[] getAttcatment2() {
		return attcatment2;
	}


	public void setAttcatment2(byte[] attcatment2) {
		this.attcatment2 = attcatment2;
	}


	public byte[] getAttcatment3() {
		return attcatment3;
	}


	public void setAttcatment3(byte[] attcatment3) {
		this.attcatment3 = attcatment3;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDropdown() {
		return dropdown;
	}


	public void setDropdown(String dropdown) {
		this.dropdown = dropdown;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public Long getAlternateNumber() {
		return alternateNumber;
	}


	public void setAlternateNumber(Long alternateNumber) {
		this.alternateNumber = alternateNumber;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getUrlRoute() {
		return urlRoute;
	}


	public void setUrlRoute(String urlRoute) {
		this.urlRoute = urlRoute;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getListCheckbox() {
		return listCheckbox;
	}


	public void setListCheckbox(String listCheckbox) {
		this.listCheckbox = listCheckbox;
	}


	public List<ClientEntity> getClientEntityList() {
		return clientEntityList;
	}


	public void setClientEntityList(List<ClientEntity> clientEntityList) {
		this.clientEntityList = clientEntityList;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", attcatment1="
				+ Arrays.toString(attcatment1) + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", state=" + state + ", country=" + country
				+ ", password=" + password + ", address=" + address + ", adminSubrole=" + adminSubrole + ", createdBy="
				+ createdBy + ", features=" + features + ", attcatment2=" + Arrays.toString(attcatment2)
				+ ", attcatment3=" + Arrays.toString(attcatment3) + ", gender=" + gender + ", dropdown=" + dropdown
				+ ", confirmPassword=" + confirmPassword + ", alternateNumber=" + alternateNumber + ", city=" + city
				+ ", role=" + role + ", urlRoute=" + urlRoute + ", dob=" + dob + ", age=" + age + ", listCheckbox="
				+ listCheckbox + ", clientEntityList=" + clientEntityList + "]";
	}





	


}