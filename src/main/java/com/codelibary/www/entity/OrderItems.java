package com.codelibary.www.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long otId;
	
	private String itemName;
	@Column(columnDefinition = "longblob")
	private byte[] itemImage;

	private String description;

	private long offerPercantage;

	private long price;
	
	
	private long diningID;
	
	private int totalItem;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="oId")
	private Order order;
	public long getOtId() {
		return otId;
	}
	public void setOtId(long otId) {
		this.otId = otId;
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
	public long getDiningID() {
		return diningID;
	}
	public void setDiningID(long diningID) {
		this.diningID = diningID;
	}
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderItems(long otId, String itemName, byte[] itemImage, String description, long offerPercantage,
			long price, long diningID, int totalItem, Order order) {
		super();
		this.otId = otId;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.description = description;
		this.offerPercantage = offerPercantage;
		this.price = price;
		this.diningID = diningID;
		this.totalItem = totalItem;
		this.order = order;
	}
	public OrderItems() {
		super();

	}
	
	
	

}
