package com.codelibary.www.service;

import java.util.Date;

public interface EmailService {
	
	public void sendEmail(String to,String from,Date sentDate, String subject, String text);
	
	 public void sendEmailWithAttachment(String to, String from, Date sentDate, String subject, String text, String attachmentPath);

}
