package com.codelibary.www.serviceimpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelibary.www.entity.ContactUs;
import com.codelibary.www.repository.ContactUsRepository;
import com.codelibary.www.service.ContactUsService;



@Service
public class ContactUsServiceimpl implements ContactUsService{
	
	@Autowired
	private ContactUsRepository contatcusRepository;

	@Override
	public ContactUs saveContactUs(ContactUs contactUs) {
	

		return contatcusRepository.save(contactUs);
	}

	@Override
	public List<ContactUs> getAllContactUs() {

		return contatcusRepository.findAll();
	}

	@Override
	public Optional<ContactUs> getContactUsById(Long id) {

		return contatcusRepository.findById(id);
	}

}
