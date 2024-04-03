package com.codelibary.www.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelibary.www.entity.Feature;
import com.codelibary.www.repository.FeatureRepository;
import com.codelibary.www.service.FeatureService;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Override
    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    @Override
    public Feature getFeatureById(long featureId) {
        return featureRepository.findById(featureId)
                .orElseThrow(() -> new RuntimeException("Feature not found with id: " + featureId));
    }

    @Override
    public Feature createFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public Feature updateFeature(long featureId, Feature updatedFeature) {
        Feature existingFeature = getFeatureById(featureId);
        existingFeature.setFeatureName(updatedFeature.getFeatureName());
        // Add other properties to update if needed
        return featureRepository.save(existingFeature);
    }

    @Override
    public void deleteFeature(long featureId) {
        featureRepository.deleteById(featureId);
    }
}