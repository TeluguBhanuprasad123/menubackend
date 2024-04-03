
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

import com.codelibary.www.entity.ContactUs;
import com.codelibary.www.service.ContactUsService;



@RestController
@RequestMapping("/contactUs")
public class ContactUsController {

	@Autowired
	private ContactUsService contactUsService;

	@PostMapping("/save")
	public ResponseEntity<ContactUs> saveEnqiuery(@RequestParam String fullName, @RequestParam String email,
			@RequestParam Long contactNumber, @RequestParam String message) {

		ContactUs contacts = new ContactUs();
		contacts.setContactNumber(contactNumber);
		contacts.setEmail(email);
		contacts.setFullName(fullName);
		contacts.setMessage(message);

		ContactUs contact = contactUsService.saveContactUs(contacts);
		return new ResponseEntity<>(contact, HttpStatus.CREATED);

	}

	@GetMapping("/getall")
	public ResponseEntity<List<ContactUs>> getllEnqiures() {
		List<ContactUs> contactall = contactUsService.getAllContactUs();
		return new ResponseEntity<>(contactall, HttpStatus.ACCEPTED);

	}

}
