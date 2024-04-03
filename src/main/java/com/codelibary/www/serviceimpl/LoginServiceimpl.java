package com.codelibary.www.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelibary.www.entity.LoginTable;
import com.codelibary.www.repository.LoginTableRepository;
import com.codelibary.www.service.EmailService;
import com.codelibary.www.service.LoginService;

@Service
public class LoginServiceimpl implements LoginService {
	
	@Autowired
	private LoginTableRepository loginTableRepository;

	@Autowired
	private EmailService emailService;
	
	@Override
	public LoginTable login(String userName, String password) {

		return loginTableRepository.findByUserNameAndPassword(userName,password);
	}

	 public LoginTable findByResetToken(String resetToken) {
	        return loginTableRepository.findByResetToken(resetToken);
	    }

	    public void generateResetTokenAndSendEmail(String email) {
//	        LoginTable user = loginTableRepository.findByUserName(userName);
//
//	        if (user != null) {
//	            // Generate a unique reset token (you may use UUID or any secure method)
//	            String resetToken = generateResetToken();
//
//	            // Save the reset token to the user's record
//	            user.setResetToken(resetToken);
//	            loginTableRepository.save(user);
//
//	            // Send an email with the reset link
//	            String resetLink = "http://your-reset-page-url?token=" + resetToken;
//	            emailService.sendEmail(email, emailUsername, null, "Password Reset",
//	                    "Click the link below to reset your password:\n" + resetLink);
//	        }
	    }

	    // Helper method to generate a unique reset token
	    private String generateResetToken() {
	        // Implement your logic to generate a unique reset token (e.g., using UUID)
	        return UUID.randomUUID().toString();
	    }

}