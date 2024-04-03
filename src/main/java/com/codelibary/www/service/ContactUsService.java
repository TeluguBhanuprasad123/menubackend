package com.codelibary.www.service;

import java.util.List;

import java.util.Optional;

import com.codelibary.www.entity.ContactUs;



public interface ContactUsService {
	
    ContactUs saveContactUs(ContactUs contactUs);
    List<ContactUs> getAllContactUs();
    Optional<ContactUs> getContactUsById(Long id );
	

}
