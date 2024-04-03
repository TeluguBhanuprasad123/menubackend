package com.codelibary.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelibary.www.entity.Admin;
import com.codelibary.www.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminFeatureController {

    @Autowired
    private AdminService adminFeatureService;

    @PostMapping("/assign-features/{adminId}")
    public Admin assignFeaturesToAdmin(@PathVariable Long adminId, @RequestBody List<Long> featureIds) {
        return adminFeatureService.assignFeaturesToAdmin(adminId, featureIds);
    }
    		
    @PutMapping("/update-features/{adminId}")
    public Admin updateFeaturesForAdmin(@PathVariable Long adminId, @RequestBody List<Long> featureIds) {
        return adminFeatureService.updateFeaturesForAdmin(adminId, featureIds);
    }
	
    @DeleteMapping("/remove-features/{adminId}")
    public Admin removeFeaturesFromAdmin(@PathVariable Long adminId, @RequestBody List<Long> featureIds) {
        return adminFeatureService.removeFeaturesFromAdmin(adminId, featureIds);
    }
		
}