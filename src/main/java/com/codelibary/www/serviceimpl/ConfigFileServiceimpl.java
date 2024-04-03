package com.codelibary.www.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.Congfile;
import com.codelibary.www.repository.ConfigFIleRepostiory;
import com.codelibary.www.service.ConfigFileService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ConfigFileServiceimpl implements ConfigFileService {

	@Autowired
	private ConfigFIleRepostiory configFIleRepostiory;

;

	@Override
	public Congfile save(MultipartFile header, MultipartFile logo,
			MultipartFile images, String city, String state,
			String country, String address, String aboutUs, String contactNumbers, String alternateNumber,
			String privacyPolicy,String organazationName,
			String contactPerson,String pincode, String termAndConditions ) throws IOException {

		


		var configSave = new Congfile();

		
		Congfile configSavess = configFIleRepostiory.save(configSave);

		return configSavess;
	}

	@Override
	public List<Congfile> getall() {
		return configFIleRepostiory.findAll();
	}

	@Override
	public Optional<Congfile> getConfigById(long configId) {

		return configFIleRepostiory.findById(configId);
	}

	@Override
	public void deleteById(long configId) {

		configFIleRepostiory.deleteById(configId);
	}

	@Override
	@Transactional
	public Congfile update(long configId, MultipartFile header, MultipartFile logo, MultipartFile images, String city,
			String state, String country, String address, String aboutUs, String contactNumbers, String alternateNumber,
			String privacyPolicy, String termAndConditions,
			
			String organazationName,
			String contactPerson,
			String pincode) throws IOException {

		Optional<Congfile> existingConfigOptional = configFIleRepostiory.findById(configId);

		if (existingConfigOptional.isPresent()) {
			Congfile existingConfig = existingConfigOptional.get();

			existingConfig.setHeader(header != null ? header.getBytes() : existingConfig.getHeader());
			existingConfig.setCity(city != null ? city : existingConfig.getCity());
			existingConfig.setState(state != null ? state : existingConfig.getState());
			existingConfig.setCountry(country != null ? country : existingConfig.getCountry());
			existingConfig.setAddress(address != null ? address : existingConfig.getAddress());
			existingConfig.setAboutUs(aboutUs != null ? aboutUs : existingConfig.getAboutUs());
			existingConfig
					.setContactNumbers(contactNumbers != null ? contactNumbers : existingConfig.getContactNumbers());
			existingConfig.setAlternateNumber(
					alternateNumber != null ? alternateNumber : existingConfig.getAlternateNumber());
			existingConfig.setPrivacyPolicy(privacyPolicy != null ? privacyPolicy : existingConfig.getPrivacyPolicy());
			existingConfig.setTermAndConditions(
					termAndConditions != null ? termAndConditions : existingConfig.getTermAndConditions());
			existingConfig.setContactPerson(contactPerson!=null ?contactPerson: existingConfig.getContactPerson());
			existingConfig.setOrganazationName(organazationName !=null ?organazationName: existingConfig.getOrganazationName());
			existingConfig.setPincode(pincode !=null ? pincode:existingConfig.getPincode() );
			return configFIleRepostiory.save(existingConfig);
		}

		throw new EntityNotFoundException("Configuration with ID " + configId + " not found");
	}

}
