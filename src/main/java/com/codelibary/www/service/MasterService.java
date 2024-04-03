package com.codelibary.www.service;

import java.util.List;

import com.codelibary.www.entity.MasterAdmin;

public interface MasterService {
	
	
	
	MasterAdmin save(
			String masterName,
			String email
		
			);
	MasterAdmin login(String email, String password);
	List<MasterAdmin> getallAdmins();
}
