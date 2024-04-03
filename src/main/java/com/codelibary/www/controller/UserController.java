//package com.codelibary.www.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.codelibary.www.entity.ClientEntity;
//import com.codelibary.www.entity.Congfile;
//import com.codelibary.www.service.ClientService;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//	@Autowired
//	private ClientService userService;
//
//	@PostMapping("/save/{configFile}")
//	public ResponseEntity<ClientEntity> userSave(@PathVariable Congfile configFile, @RequestParam String userName,
//												 @RequestParam String dob, @RequestParam Long contactNumber, @RequestParam Long alternateNumber,
//												 @RequestParam String email, @RequestParam String address, @RequestParam MultipartFile attachments,
//												 @RequestParam(required = false) MultipartFile attachments1, @RequestParam(required = false) MultipartFile attachments2,
//												 @RequestParam String city, @RequestParam String state, @RequestParam String country,
//												 @RequestParam(required = false) String experience, @RequestParam(required = false) String education, @RequestParam(required = false) String about
//
//	) throws IOException {
//		ClientEntity us = userService.saveUser(configFile, userName, dob, contactNumber, alternateNumber, email, address,
//				education, experience, about, attachments, attachments1, attachments2, city, state, country);
//		return new ResponseEntity<ClientEntity>(us, HttpStatus.CREATED);
//
//	}
//
//	@GetMapping("/getall")
//	public ResponseEntity<List<ClientEntity>> getallUsers() {
//		List<ClientEntity> userS = userService.getAllUsers();
//		return new ResponseEntity<>(userS, HttpStatus.ACCEPTED);
//	}
//
//	@GetMapping("/getUsers/{configId}")
//	public ResponseEntity<List<ClientEntity>> getUserByConfigId(@PathVariable Long configId) {
//
//		List<ClientEntity> usersByConfigId = userService.getUsersByConfigId(configId);
//		return new ResponseEntity<>(usersByConfigId, HttpStatus.ACCEPTED);
//	}
//
//}
