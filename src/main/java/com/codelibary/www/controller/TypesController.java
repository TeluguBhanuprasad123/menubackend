package com.codelibary.www.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.dtos.TypesWithCatIdDTO;
import com.codelibary.www.entity.Categories;
import com.codelibary.www.entity.Types;
import com.codelibary.www.service.TypeService;

@RestController
@RequestMapping("/Types")
public class TypesController {
	
	@Autowired
	private TypeService typeService;
	
    @PostMapping("/saveType/{catId}")
    public ResponseEntity<Types> saveType(
            @RequestParam String typeName,
            @RequestParam("typeImage") MultipartFile typeImage,
            @PathVariable Categories catId
    ) throws IOException {
     
        Types savedType = typeService.saveType(typeName, typeImage, catId);

        return new ResponseEntity<>(savedType, HttpStatus.CREATED);
    }

    @GetMapping("/getTypesByCategoryId/{businessId}")
    public ResponseEntity<List<Types>> getTypesByCategoryId(@PathVariable String businessId) {
        List<Types> types = typeService.getTypesByCategoryId(businessId);
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

	

}
