package com.codelibary.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelibary.www.entity.Feature;
import com.codelibary.www.service.FeatureService;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping("/getall")
    public List<Feature> getAllFeatures() {
        return featureService.getAllFeatures();
    }

    @GetMapping("/{featureId}")
    public Feature getFeatureById(@PathVariable long featureId) {
        return featureService.getFeatureById(featureId);
    }

    @PostMapping("/create")
    public Feature createFeature(@RequestBody Feature feature) {
        return featureService.createFeature(feature);
    }

    @PutMapping("/{featureId}")
    public Feature updateFeature(@PathVariable long featureId, @RequestBody Feature updatedFeature) {
        return featureService.updateFeature(featureId, updatedFeature);
    }

    @DeleteMapping("/{featureId}")
    public void deleteFeature(@PathVariable long featureId) {
        featureService.deleteFeature(featureId);
    }
}
