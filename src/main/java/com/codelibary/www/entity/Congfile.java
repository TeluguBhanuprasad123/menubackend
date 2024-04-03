package com.codelibary.www.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Congfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long configId;

	@Column(columnDefinition = "longblob")
	private byte[] header;

	@Column(columnDefinition = "longblob")

	private byte[] logo;

	@Column(columnDefinition = "longblob")
	private byte[] images;

	@Column(name = "organazation_Name")
	private String organazationName;
	@Column(name = "contact_Person")
	private String contactPerson;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
	@Column(name = "address")
	private String address;

	@Column(name = "aboutUs", columnDefinition = "LONGTEXT")
	private String aboutUs;

	@Column(name = "contact_Number")
	private String contactNumbers;
	@Column(name = "alternate_Number")
	private String alternateNumber;

	@Column(name = "privacyPolicy", columnDefinition = "LONGTEXT")
	private String privacyPolicy;
	@Column(name = "termAndConditions", columnDefinition = "LONGTEXT")
	private String termAndConditions;
	
	private String pincode;

	public long getConfigId() {
		return configId;
	}

	public void setConfigId(long configId) {
		this.configId = configId;
	}

	public byte[] getHeader() {
		return header;
	}

	public void setHeader(byte[] header) {
		this.header = header;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	public String getOrganazationName() {
		return organazationName;
	}

	public void setOrganazationName(String organazationName) {
		this.organazationName = organazationName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	public String getContactNumbers() {
		return contactNumbers;
	}

	public void setContactNumbers(String contactNumbers) {
		this.contactNumbers = contactNumbers;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getPrivacyPolicy() {
		return privacyPolicy;
	}

	public void setPrivacyPolicy(String privacyPolicy) {
		this.privacyPolicy = privacyPolicy;
	}

	public String getTermAndConditions() {
		return termAndConditions;
	}

	public void setTermAndConditions(String termAndConditions) {
		this.termAndConditions = termAndConditions;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Congfile(long configId, byte[] header, byte[] logo, byte[] images, String organazationName,
			String contactPerson, String city, String state, String country, String address, String aboutUs,
			String contactNumbers, String alternateNumber, String privacyPolicy, String termAndConditions,
			String pincode) {
		super();
		this.configId = configId;
		this.header = header;
		this.logo = logo;
		this.images = images;
		this.organazationName = organazationName;
		this.contactPerson = contactPerson;
		this.city = city;
		this.state = state;
		this.country = country;
		this.address = address;
		this.aboutUs = aboutUs;
		this.contactNumbers = contactNumbers;
		this.alternateNumber = alternateNumber;
		this.privacyPolicy = privacyPolicy;
		this.termAndConditions = termAndConditions;
		this.pincode = pincode;
	}

	public Congfile() {
		super();
	
	}







}
