package com.codelibary.www.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.Categories;
import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.service.CategoriesService;
import com.codelibary.www.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/CategoryController")
public class CategoriesController {
	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private ClientService clientService; 
	
	@PostMapping("/saveCat/{bussiness_id}")
	public ResponseEntity<Categories> saveCategory(@RequestParam String categoryName,
			@RequestParam("catImage") MultipartFile catImage, @PathVariable ClientEntity bussiness_id)
			throws IOException {

		Categories savedCategory = categoriesService.saveCategory(categoryName, catImage, bussiness_id);

		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}

	@GetMapping("/business/{businessId}")
	public List<Categories> getCategoriesByBusinessId(@PathVariable String businessId) {
		return categoriesService.getCategoriesByBusinessId(businessId);
	}	
	
	@GetMapping("/get/{catId}")
	public Categories getByCatId(@PathVariable long catId) {
		
		return categoriesService.getCategoryById(catId);
	}

	@PutMapping("/updateCat/{catId}")
	public ResponseEntity<?> updateCategory(@PathVariable long catId,
	                                                 @RequestParam String categoryName,
	                                                 @RequestParam(name = "catImage", required = false) MultipartFile catImage,
	                                                 @RequestParam String businessId) {
	    try {
	        System.err.println(categoryName);
	        System.err.println(catId);
	        System.err.println(businessId);

	        // Validation
	        if (categoryName == null || categoryName.trim().isEmpty() || businessId == null || businessId.trim().isEmpty()) {
	            return new ResponseEntity<>("CategoryName and businessId cannot be null or empty.", HttpStatus.BAD_REQUEST);
	        }

	        // Fetch the existing category
	        Categories existingCategory = categoriesService.getCategoryById(catId);

	        System.err.println(existingCategory.getCategoryName());
	        if (existingCategory == null) {
	            return new ResponseEntity<>("Category not found for ID: " + catId, HttpStatus.NOT_FOUND);
	        }

	        // Update the category details
	        existingCategory.setCategoryName(categoryName);

	        // Update image if provided
	        if (catImage != null && !catImage.isEmpty()) {
	            // Additional file validation can be performed here
	            existingCategory.setCatImage(catImage.getBytes());
	        }

	        // Set the client entity based on businessId
	        existingCategory.setClientEntity(clientService.getByBussinessId(businessId));
	        System.err.println(existingCategory.getCategoryName());

	    
	        
	        // Save the updated category
	        Categories updatedCategory = categoriesService.saveCategory(existingCategory);

	        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	    } catch (IOException e) {
	        // Handle file processing exception
	        return new ResponseEntity<>("Error processing file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	@DeleteMapping("/deleteCat/{catId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable long catId) {
	    Categories existingCategory = categoriesService.getCategoryById(catId);

	    if (existingCategory == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // or HttpStatus.BAD_REQUEST
	    }

	    categoriesService.deleteCategory(catId);

	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
