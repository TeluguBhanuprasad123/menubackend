package com.codelibary.www.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Departments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cdid;
	
	private String depName;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "bussiness_id")
	private ClientEntity clientEnitys;


	public long getCdid() {
		return cdid;
	}

	public void setCdid(long cdid) {
		this.cdid = cdid;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public ClientEntity getClientEnitys() {
		return clientEnitys;
	}

	public void setClientEnitys(ClientEntity clientEnitys) {
		this.clientEnitys = clientEnitys;
	}

	public Departments(long cdid, String depName, ClientEntity clientEnitys) {
		super();
		this.cdid = cdid;
		this.depName = depName;
		this.clientEnitys = clientEnitys;
	}

	public Departments() {
		super();

	}

	
	
	
       
}
