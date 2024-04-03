package com.codelibary.www.service;

import com.codelibary.www.entity.LoginTable;

public interface LoginService {
	LoginTable login(String userName, String password);

	void generateResetTokenAndSendEmail(String email);
}
