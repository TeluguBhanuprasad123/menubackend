package com.codelibary.www.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.ClientUsers;

public interface ClientUserService {

	ClientUsers saveClientUser(String cname, String contactNumber, String specialization, String dob, String email,
 String address, String adharNumber, String panNumber,  MultipartFile clogo,
		 String gender, ClientEntity bussinessId) throws IOException;

	List<ClientUsers> getAllClientUsers();

	ClientUsers getClientUserById(long Id);
	   List<ClientUsers> getAllUsersByBusinessId(String businessId);
	void deleteClientUser(long Id);

	ClientUsers updateClientUser(long Id, String cname, Long contactNumber, String specialization, String dob,
			String email, String role, String address, String adharNumber, String panNumber, String password,
			MultipartFile clogo, int age, String gender);
	
	List<ClientUsers> getTotalClientUsers();
	
}
