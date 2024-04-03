package com.codelibary.www.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.CustomExcption.ClientEntityNotfoundException;
import com.codelibary.www.entity.Categories;
import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.Types;
import com.codelibary.www.repository.ClientRepository;
import com.codelibary.www.repository.TypesRepoisotry;
import com.codelibary.www.service.TypeService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TypeServiceimpl implements TypeService{
	@Autowired
	private TypesRepoisotry typesRepoisotry;
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Types saveType(
	        String typeName,
	        MultipartFile typeImage,
	        Categories catId) throws IOException {

	    ClientEntity clientEntity = catId.getClientEntity();

	    if (clientEntity == null) {
	        throw new ClientEntityNotfoundException("ClientEntity not found for the given Categories");
	    }

	    // Now you can get the business ID from the ClientEntity
	    String businessId = clientEntity.getBussiness_id();

	    // Fetch the ClientEntity from the database based on the business ID
	    ClientEntity fetchedClientEntity = clientRepository.findByBussinessId(businessId);

	    if (fetchedClientEntity == null) {
	        throw new EntityNotFoundException("ClientEntity not found for the given business ID");
	    }

	  
	    Types tySave = new Types();
	    tySave.setTypeName(typeName);
	    tySave.setTypeImage(typeImage.getBytes());
	    tySave.setCategories(catId);
	    tySave.setClientEntity(fetchedClientEntity);


	    return typesRepoisotry.save(tySave);
	}


	@Override
	public List<Types> getTypesByCategoryId(String businessId) {
	    return typesRepoisotry.findAllByBusinessId(businessId);
	}


}
