package com.codelibary.www.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.Congfile;

public interface ConfigFileService {

	Congfile save(

		    MultipartFile header,
		    MultipartFile logo,
		    MultipartFile images,
		    String city,
		    String state,
		    String country,
		    String address,
		    String aboutUs,
		    String contactNumbers,
		    String alternateNumber,
		    String privacyPolicy,
		    String organazationName,
		    String contactPerson,
		    String pincode,
		    String termAndConditions

		) throws IOException;

	List<Congfile> getall();

	Optional<Congfile> getConfigById(long configId);

	void deleteById(long configId);

	Congfile update(long configId,MultipartFile header, MultipartFile logo, MultipartFile images, String city, String state, String country,
			String address, String aboutUs, String contactNumbers, String alternateNumber, String privacyPolicy,
			String termAndConditions,
			String organazationName,
			String contactPerson,
			String pincode) throws IOException;

}
