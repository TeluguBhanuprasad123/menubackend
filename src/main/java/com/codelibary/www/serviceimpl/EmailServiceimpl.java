package com.codelibary.www.serviceimpl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.codelibary.www.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceimpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String to, String from, Date sentDate, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setSentDate(sentDate);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
	
		javaMailSender.send(message);
	}

	@Override
	public void sendEmailWithAttachment(String to, String from, Date sentDate, String subject, String text,
			String attachmentPath) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(from);
			helper.setSentDate(sentDate);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
		
			File attachment = new File(attachmentPath);
			helper.addAttachment(attachment.getName(), attachment);

			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
