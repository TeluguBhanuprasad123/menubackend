package com.codelibary.www.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.Items;
import com.codelibary.www.entity.Types;
import com.codelibary.www.service.ItemsService;

@RestController
@RequestMapping("/ItemSave")
public class ItemController {

	@Autowired
	private ItemsService itemsService;

	@PostMapping("/save/{typeId}")
	public ResponseEntity<Items> saveItemByTypeId(@PathVariable Types typeId, @RequestParam String itemName,
			@RequestParam MultipartFile itemImage, @RequestParam String description, @RequestParam long offerPercentage,
			@RequestParam long price) {

		try {

			Items savedItem = itemsService.saveItemByTypeId(typeId, itemName, itemImage, description, offerPercentage,
					price);

			return ResponseEntity.ok(savedItem);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/byBusinessId/{businessId}")
	public List<Items> getItemsByBusinessId(@PathVariable String businessId) {
		return itemsService.findItemsByBusinessId(businessId);
	}

	
	 @PutMapping("/update/{itemId}")
	    public ResponseEntity<Items> updateItem(@PathVariable Long itemId,
	                                            @RequestParam(name = "itemName",required = false) String itemName,
	                                            @RequestParam(name = "itemImage",required = false) MultipartFile itemImage,
	                                            @RequestParam String description,
	                                            @RequestParam long offerPercentage,
	                                            @RequestParam long price) {

	        try {
	            Items updatedItem = itemsService.updateItem(itemId, itemName, itemImage, description, offerPercentage, price);

	            if (updatedItem != null) {
	                return ResponseEntity.ok(updatedItem);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }

	    @DeleteMapping("/delete/{itemId}")
	    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
	        if (itemsService.deleteItem(itemId)) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
}
