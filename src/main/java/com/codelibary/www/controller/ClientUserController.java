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

import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.ClientUsers;
import com.codelibary.www.service.ClientUserService;

@RestController
@RequestMapping("/clientUserController")
public class ClientUserController {

	@Autowired
	private ClientUserService clientUserService;

	@PostMapping("/save/{bussinessId}")
	public ResponseEntity<ClientUsers> clientUsersSave(@PathVariable ClientEntity bussinessId,
			@RequestParam String cname, @RequestParam String contactNumber, @RequestParam String specialization,
			@RequestParam String dob, @RequestParam String email, @RequestParam String address,
			@RequestParam String adharNumber, @RequestParam String panNumber, @RequestParam MultipartFile clogo,
			@RequestParam String gender) throws IOException {

		ClientUsers d = clientUserService.saveClientUser(cname, contactNumber, specialization, dob, email, address,
				adharNumber, panNumber, clogo, gender, bussinessId);

		return new ResponseEntity<>(d, HttpStatus.OK);

	}

	@GetMapping("/business/{businessId}")
	public ResponseEntity<List<ClientUsers>> getAllUsersByBusinessId(@PathVariable String businessId) {
		List<ClientUsers> users = clientUserService.getAllUsersByBusinessId(businessId);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	

  
}
