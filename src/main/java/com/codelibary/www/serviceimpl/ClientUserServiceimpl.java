package com.codelibary.www.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.CustomExcption.ClientUserNotFoundException;
import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.ClientUsers;
import com.codelibary.www.entity.LoginTable;
import com.codelibary.www.repository.ClientUsersRepository;
import com.codelibary.www.repository.LoginTableRepository;
import com.codelibary.www.service.ClientUserService;

@Service
public class ClientUserServiceimpl implements ClientUserService {

	@Autowired
	private ClientUsersRepository clientUsersRepository;
	@Autowired
	private LoginTableRepository loginTableRepository;
	ClientUsers d;

	@Override
	public ClientUsers saveClientUser(String cname, String contactNumber, String specialization, String dob, String email,

			String address, String adharNumber, String panNumber,

			MultipartFile clogo,

			String gender, ClientEntity bussinessId) throws IOException {

		d = new ClientUsers();
		d.setCname(cname);
		d.setContactNumber(contactNumber);
		d.setSpecialization(specialization);
		d.setDob(dob);
		d.setEmail(email);
		d.setRole("Cleint_user");
		d.setAddress(address);
		d.setAdharNumber(adharNumber);
		d.setPanNumber(panNumber);
		String password = RandomStringUtils.randomAlphanumeric(6);
		d.setPassword(password);
        d.setClogo(clogo.getBytes());
		d.setGender(gender);
		d.setClientEnity(bussinessId);
		
		ClientUsers ds = clientUsersRepository.save(d);

		LoginTable loginTable = new LoginTable();
        
		loginTable.setRole(ds.getRole());
		loginTable.setUserName(ds.getCname());
		loginTable.setPassword(ds.getPassword());
		loginTable.setClientUser(ds);
		
		loginTableRepository.save(loginTable);
		return ds;
	}

	@Override
	public List<ClientUsers> getAllClientUsers() {

		return clientUsersRepository.findAll();
	}

	@Override
	public ClientUsers getClientUserById(long id) {
		return clientUsersRepository.findById(id)
				.orElseThrow(() -> new ClientUserNotFoundException("Client user with ID " + id + " not found"));
	}

	@Override
	public void deleteClientUser(long Id) {

		clientUsersRepository.deleteById(Id);
	}

	@Override
	public ClientUsers updateClientUser(long Id, String cname, Long contactNumber, String specialization, String dob,
			String email, String role, String address, String adharNumber, String panNumber, String password,
			MultipartFile clogo, int age, String gender) {

		return null;
	}

	@Override
	public List<ClientUsers> getAllUsersByBusinessId(String businessId) {
		// TODO Auto-generated method stub
		return clientUsersRepository.findByBusinessIdNative(businessId);
	}

	@Override
	public List<ClientUsers> getTotalClientUsers() {
	
		return clientUsersRepository.findAll();
	}

}
