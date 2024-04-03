package com.codelibary.www.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long catId;
	
	private String categoryName;
	
	@Column(columnDefinition = "longblob")
	private byte[]  catImage;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="bussiness_id")
	private ClientEntity clientEntity;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Types> types=new ArrayList<>();

	public long getCatId() {
		return catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public byte[] getCatImage() {
		return catImage;
	}

	public void setCatImage(byte[] catImage) {
		this.catImage = catImage;
	}

	public ClientEntity getClientEntity() {
		return clientEntity;
	}

	public void setClientEntity(ClientEntity clientEntity) {
		this.clientEntity = clientEntity;
	}

	public List<Types> getTypes() {
		return types;
	}

	public void setTypes(List<Types> types) {
		this.types = types;
	}

	public Categories(long catId, String categoryName, byte[] catImage, ClientEntity clientEntity, List<Types> types) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
		this.catImage = catImage;
		this.clientEntity = clientEntity;
		this.types = types;
	}

	public Categories() {
		super();
	
	}

	
	
	
	

}
