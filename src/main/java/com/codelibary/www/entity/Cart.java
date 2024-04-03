package com.codelibary.www.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ctid;
	
	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "total_item")
	private int totalItem;
	
	
	private String status;
    
    @JsonIgnore
	@OneToOne
	@JoinColumn(name = "table_id")
	private DiningTable diningTable;


	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "cart_items")
	private List<CartItem> cartItems = new ArrayList<>();


	public long getCtid() {
		return ctid;
	}


	public void setCtid(long ctid) {
		this.ctid = ctid;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public int getTotalItem() {
		return totalItem;
	}


	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public DiningTable getDiningTable() {
		return diningTable;
	}


	public void setDiningTable(DiningTable diningTable) {
		this.diningTable = diningTable;
	}


	public List<CartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}


	public Cart(long ctid, double totalPrice, int totalItem, String status, DiningTable diningTable,
			List<CartItem> cartItems) {
		super();
		this.ctid = ctid;
		this.totalPrice = totalPrice;
		this.totalItem = totalItem;
		this.status = status;
		this.diningTable = diningTable;
		this.cartItems = cartItems;
	}


	public Cart() {
		super();

	}
	
	
	

}
