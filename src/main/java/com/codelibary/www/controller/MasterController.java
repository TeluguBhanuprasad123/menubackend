package com.codelibary.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelibary.www.entity.MasterAdmin;
import com.codelibary.www.service.MasterService;


@RestController
@RequestMapping("/master")
public class MasterController {
	
	@Autowired
	private MasterService masterService;
	
	
	@PostMapping("/save")
	public ResponseEntity<MasterAdmin> masterAdminSave(@RequestParam String masterName, @RequestParam String email ) {

		MasterAdmin msave = masterService.save(masterName, email);
		return new ResponseEntity<MasterAdmin>(msave, HttpStatus.CREATED);

	}
	@GetMapping("/getall")
	public List<MasterAdmin> getallAdmins(){
		return masterService.getallAdmins();
		
	}


}
