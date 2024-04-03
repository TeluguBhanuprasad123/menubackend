package com.codelibary.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelibary.www.LoginResponse;
import com.codelibary.www.entity.LoginTable;
import com.codelibary.www.repository.LoginTableRepository;
import com.codelibary.www.service.LoginService;
;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LoginTableRepository loginTableRepository;
	
	@PostMapping("/validate")
    public ResponseEntity<LoginResponse> login(@RequestParam String userName, @RequestParam String password) {
        LoginTable loggedInUser = loginService.login(userName, password);

        if (loggedInUser != null) {
         
            LoginResponse response = new LoginResponse("Login successful", loggedInUser);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Invalid credentials", null));
        }
    }

	  @PostMapping("/forgot-password")
	    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
	        loginService.generateResetTokenAndSendEmail(email);
	        return ResponseEntity.ok("Password reset instructions sent to your email.");
	    }

	    // Implement an endpoint for handling password reset
//	    @PostMapping("/reset-password")
//	    public ResponseEntity<LoginResponse> resetPassword(@RequestParam String resetToken, @RequestParam String newPassword) {
//	        LoginTable user = loginService.findByResetToken(resetToken);
//
//	        if (user != null) {
//	            // Update the user's password
//	            user.setPassword(newPassword);
//	            user.setResetToken(null); // Clear the reset token after password reset
//	            loginTableRepository.save(user);
//
//	            // You may also send a confirmation email here
//
//	            LoginResponse response = new LoginResponse("Password reset successful", user);
//	            return ResponseEntity.ok(response);
//	        } else {
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginResponse("Invalid reset token", null));
//	        }
//	    }
	
}