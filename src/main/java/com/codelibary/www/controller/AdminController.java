package com.codelibary.www.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.codelibary.www.entity.Admin;
import com.codelibary.www.enums.AdminSubRole;
import com.codelibary.www.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/save")
	public ResponseEntity<Admin> saveAdmin(
	        @RequestParam String lastName,
	        @RequestParam String firstName,
	        @RequestParam String email,
	        @RequestParam Long contactNumber,
	        @RequestParam String address,
	        @RequestParam(required = false) MultipartFile attactment1,
	        @RequestParam AdminSubRole adminSubrole,
	        @RequestParam String state,
	        @RequestParam String country,
	        @RequestParam(required = false) List<Long> featureIds // Add this parameter for featureIds
	) throws IOException {
	    Admin adminsave = adminService.save(firstName, lastName, email, contactNumber, attactment1, address, adminSubrole, state, country, featureIds);
	    return new ResponseEntity<>(adminsave, HttpStatus.CREATED);
	}


	@GetMapping("/getall")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		List<Admin> admins = adminService.getallAdmins();
		return new ResponseEntity<>(admins, HttpStatus.OK);
	}
	
	@GetMapping("/get/{adminId}")
	public ResponseEntity<Optional<Admin>> getAdminByid(@PathVariable Long adminId){
		Optional<Admin> adminByid=adminService.getAdminById(adminId);
		return new ResponseEntity<Optional<Admin>>(adminByid, HttpStatusCode.valueOf(200));
	}

	@PutMapping("/update/{adminId}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long adminId,
			@RequestParam(required = false) String lastName, 
			@RequestParam(required = false) String firstName, 
			@RequestParam(required = false) String email,
			@RequestParam(required = false) Long contactNumber, 
			@RequestParam(required = false) String address,
			@RequestParam(required = false) MultipartFile attactment1,
			@RequestParam(required = false) AdminSubRole adminSubrole) throws IOException {

		Admin updatedAdmin = adminService.updateAdmin(adminId, address, attactment1, firstName, lastName,
				contactNumber, email, lastName, firstName, email, address, adminSubrole);

		return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{adminId}")
	public ResponseEntity<String> deleteAdmin(@PathVariable Long adminId) {
		adminService.deleteAdmin(adminId);
		return new ResponseEntity<>("Admin with ID " + adminId + " has been deleted.", HttpStatus.OK);
	}
	
	
//
//	@PostMapping(path = EndPoints.ADMIN_CHECK_USER_ALREADYEXITS)
//	public ResponseEntity<String> checkAdminExistence(@RequestParam String adminName) {
//		boolean adminExists = adminRegistartionService.isExistingAdmin(adminName);
//
//		if (adminExists) {
//			return new ResponseEntity<>("Admin already exists", HttpStatus.BAD_REQUEST);
//		} else {
//			return new ResponseEntity<>("Admin does not exist", HttpStatus.OK);
//		}
//	}

	@PutMapping("/reserPassword/{adminId}")
	public ResponseEntity<String> resetPassword(@PathVariable Long adminId, @RequestParam String oldPassword,
			@RequestParam String newPassword, @RequestParam String confirmPassword) {
		adminService.resetPassword(adminId, oldPassword, newPassword, confirmPassword);
		return ResponseEntity.ok("Password reset successfully for admin with ID: " + adminId);
	}


}