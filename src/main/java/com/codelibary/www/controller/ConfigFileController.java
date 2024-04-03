package com.codelibary.www.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.Congfile;
import com.codelibary.www.service.ConfigFileService;

@RestController
@RequestMapping("/ConfigFile")
public class ConfigFileController {

	@Autowired
	private ConfigFileService configFileService;

	@PostMapping("/save/{bussinessCategId}")
	public ResponseEntity<Congfile> configSave(
			@RequestParam(required = false) MultipartFile header,
			@RequestParam(required = false) MultipartFile logo,
			@RequestParam(required = false) MultipartFile images,
			@RequestParam String city,
			@RequestParam String state, 
			@RequestParam String country,
			@RequestParam String address, 
			@RequestParam String aboutUs,
			@RequestParam String contactNumbers,
			@RequestParam String alternateNumber,
			@RequestParam(required = false) String privacyPolicy,
			@RequestParam(required = false) String termAndConditions,
			@RequestParam(required = false) String  contactPerson,
			@RequestParam(required = false) String  organazationName,
			@RequestParam(required = false) String pincode
      

            ) throws IOException {




		Congfile configSave = configFileService.save(
				header,
				logo,
				images,
				city, 
				state,
				country, 
				address,
				aboutUs,
				organazationName,
				contactPerson, 
				contactNumbers, 
				alternateNumber,
				privacyPolicy,
				pincode,
				termAndConditions
                );

		
		return new ResponseEntity<>(configSave, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Congfile>> getall() {
		List<Congfile> configGet = configFileService.getall();
		return new ResponseEntity<>(configGet, HttpStatus.ACCEPTED);
	}

	@GetMapping("/get/{configId}")
	public ResponseEntity<Optional<Congfile>> getConfigByid(@PathVariable long configId) {
		Optional<Congfile> configGetByid = configFileService.getConfigById(configId);
		return new ResponseEntity<>(configGetByid, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{configId}")
	public ResponseEntity<Congfile> updateConfig(@PathVariable long configId, @RequestParam MultipartFile header,
			@RequestParam MultipartFile logo, @RequestParam MultipartFile images, @RequestParam String city,
			@RequestParam String state, @RequestParam String country, @RequestParam String address,
			@RequestParam String aboutUs, @RequestParam String contactNumbers, @RequestParam String alternateNumber,
			@RequestParam String privacyPolicy, @RequestParam String termAndConditions,
			
			@RequestParam(required = false) String  contactPerson,
			@RequestParam(required = false) String  organazationName,
			@RequestParam(required = false) String pincode) throws IOException {

		Congfile configUpdate = configFileService.update(configId, header, logo, images, city, state, country, address, aboutUs, contactNumbers, alternateNumber, privacyPolicy, termAndConditions, organazationName, contactPerson, pincode);
		return new ResponseEntity<Congfile>(configUpdate, HttpStatus.ACCEPTED);

	}

}
