package com.codelibary.www.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class DiningTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tableId;

	private String tableName;

	@ManyToOne
	@JoinColumn(name = "bussiness_id")
	private ClientEntity clientEntity;

	@Column(columnDefinition = "longblob")
	private byte[] qrcode;

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public ClientEntity getClientEntity() {
		return clientEntity;
	}

	public void setClientEntity(ClientEntity clientEntity) {
		this.clientEntity = clientEntity;
	}

	public byte[] getQrcode() {
		return qrcode;
	}

	public void setQrcode(byte[] qrcode) {
		this.qrcode = qrcode;
	}

	public DiningTable(Long tableId, String tableName, ClientEntity clientEntity, byte[] qrcode) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.clientEntity = clientEntity;
		this.qrcode = qrcode;
	}

	public DiningTable() {
		super();
		// TODO Auto-generated constructor stub
	}



	
}
