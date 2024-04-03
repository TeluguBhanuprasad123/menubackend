package com.codelibary.www.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Types {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tId;

	private String typeName;
	@Column(columnDefinition = "longblob")
	private byte[] typeImage;
	@JsonBackReference
	@ManyToOne

	@JoinColumn(name = "catId")
	private Categories categories;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "bussiness_id")
	private ClientEntity clientEntity;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "types", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Items> items=new ArrayList<>();

	public long gettId() {
		return tId;
	}

	public void settId(long tId) {
		this.tId = tId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public byte[] getTypeImage() {
		return typeImage;
	}

	public void setTypeImage(byte[] typeImage) {
		this.typeImage = typeImage;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public ClientEntity getClientEntity() {
		return clientEntity;
	}

	public void setClientEntity(ClientEntity clientEntity) {
		this.clientEntity = clientEntity;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public Types(long tId, String typeName, byte[] typeImage, Categories categories, ClientEntity clientEntity,
			List<Items> items) {
		super();
		this.tId = tId;
		this.typeName = typeName;
		this.typeImage = typeImage;
		this.categories = categories;
		this.clientEntity = clientEntity;
		this.items = items;
	}

	public Types() {
		super();

	}


	
}
