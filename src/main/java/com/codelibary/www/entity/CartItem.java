package com.codelibary.www.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cItd;



	private double price;

	private long quantity;

	private long diningID;
    @JsonIgnore
	@ManyToOne
	private Cart cart;

	@ManyToOne
    private Items items;
	public Long getcItd() {
		return cItd;
	}
	public void setcItd(Long cItd) {
		this.cItd = cItd;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getDiningID() {
		return diningID;
	}
	public void setDiningID(long diningID) {
		this.diningID = diningID;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public CartItem(Long cItd, double price, long quantity, long diningID, Cart cart, Items items) {
		super();
		this.cItd = cItd;
		this.price = price;
		this.quantity = quantity;
		this.diningID = diningID;
		this.cart = cart;
		this.items = items;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
