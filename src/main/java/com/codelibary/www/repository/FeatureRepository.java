package com.codelibary.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelibary.www.entity.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
    // Additional custom queries can be added here if needed
}