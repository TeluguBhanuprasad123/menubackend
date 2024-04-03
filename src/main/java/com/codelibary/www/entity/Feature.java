package com.codelibary.www.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Feature")
public class Feature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long featureId;
	
	// front end routes names 
	@Column(name = "featureName")
	private String featureName;

	public Feature(long featureId, String featureName) {
		super();
		this.featureId = featureId;
		this.featureName = featureName;
	}

	public Feature() {
		super();
	}

	public long getFeatureId() {
		return featureId;
	}

	public void setFeatureId(long featureId) {
		this.featureId = featureId;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	@Override
	public String toString() {
		return "Feature [featureId=" + featureId + ", featureName=" + featureName + "]";
	}
	
}