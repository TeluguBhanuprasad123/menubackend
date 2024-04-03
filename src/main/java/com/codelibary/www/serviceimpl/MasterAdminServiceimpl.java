package com.codelibary.www.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelibary.www.entity.LoginTable;
import com.codelibary.www.entity.MasterAdmin;
import com.codelibary.www.repository.LoginTableRepository;
import com.codelibary.www.repository.MasterAdminRepository;
import com.codelibary.www.service.MasterService;

@Service
public class MasterAdminServiceimpl implements MasterService {

	@Autowired
	private MasterAdminRepository masterRepository;
	@Autowired
   private LoginTableRepository loginTableRepository;

	@Autowired
	private PasswordGenerator passwordGenerator;

	@Override
	public MasterAdmin save(String masterName, String email

	) {

		MasterAdmin ms = new MasterAdmin();
		ms.setMasterName(masterName);
		ms.setEmail(email);
		String generatedPassword = passwordGenerator.generatePassword(8); // You can specify the desired length
		ms.setRole("Master");
		ms.setPassword(generatedPassword);

		MasterAdmin mastersave = masterRepository.save(ms);
		
        LoginTable logins=new LoginTable();
        logins.setMasterAdmin(mastersave);
        logins.setPassword(mastersave.getPassword());
        logins.setRole(mastersave.getRole());
        logins.setUserName(mastersave.getEmail());
        loginTableRepository.save(logins);
		return mastersave;
	}
	
	@Override
	public List<MasterAdmin> getallAdmins(){
		return masterRepository.findAll();
		
	}

	@Override
	public MasterAdmin login(String email, String password) {

		return masterRepository.findByEmailAndPassword(email, password);

	}

}
