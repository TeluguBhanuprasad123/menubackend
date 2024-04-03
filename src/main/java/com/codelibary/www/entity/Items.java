package com.codelibary.www.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itID;

	private String itemName;
	@Column(columnDefinition = "longblob")
	private byte[] itemImage;

	private String description;

	private long offerPercantage;

	private long price;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="tId")
	private Types types;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "bussiness_id")
	private ClientEntity clientEntity;
	public long getItID() {
		return itID;
	}
	public void setItID(long itID) {
		this.itID = itID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public byte[] getItemImage() {
		return itemImage;
	}
	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getOfferPercantage() {
		return offerPercantage;
	}
	public void setOfferPercantage(long offerPercantage) {
		this.offerPercantage = offerPercantage;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Types getTypes() {
		return types;
	}
	public void setTypes(Types types) {
		this.types = types;
	}
	public ClientEntity getClientEntity() {
		return clientEntity;
	}
	public void setClientEntity(ClientEntity clientEntity) {
		this.clientEntity = clientEntity;
	}
	public Items(long itID, String itemName, byte[] itemImage, String description, long offerPercantage, long price,
			Types types, ClientEntity clientEntity) {
		super();
		this.itID = itID;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.description = description;
		this.offerPercantage = offerPercantage;
		this.price = price;
		this.types = types;
		this.clientEntity = clientEntity;
	}
	public Items() {
		super();

	}
	
	
}
