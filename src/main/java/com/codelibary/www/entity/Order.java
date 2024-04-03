package com.codelibary.www.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders") 
public class Order {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oId;

	private LocalDateTime orderDate;

	private double totalPrice;

	private int totalItem;

	private LocalDateTime createdAt;
	
	private String orderStatus;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItems> orderItems = new ArrayList<>();

	public long getoId() {
		return oId;
	}

	public void setoId(long oId) {
		this.oId = oId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	public Order(long oId, LocalDateTime orderDate, double totalPrice, int totalItem, LocalDateTime createdAt,
			String orderStatus, List<OrderItems> orderItems) {
		super();
		this.oId = oId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.totalItem = totalItem;
		this.createdAt = createdAt;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}

	public Order() {
		super();
	
	}

	
	

}
