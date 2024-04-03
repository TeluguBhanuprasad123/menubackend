package com.codelibary.www.service;

import java.util.List;

import com.codelibary.www.entity.Feature;

public interface FeatureService {
    List<Feature> getAllFeatures();

    Feature getFeatureById(long featureId);

    Feature createFeature(Feature feature);

    Feature updateFeature(long featureId, Feature updatedFeature);

    void deleteFeature(long featureId);
}