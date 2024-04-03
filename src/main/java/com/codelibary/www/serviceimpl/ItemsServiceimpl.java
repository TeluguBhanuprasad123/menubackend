package com.codelibary.www.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.CustomExcption.ClientEntityNotfoundException;
import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.Items;
import com.codelibary.www.entity.Types;
import com.codelibary.www.repository.ItemsRepository;
import com.codelibary.www.service.ItemsService;

@Service
public class ItemsServiceimpl implements ItemsService{
	
	@Autowired
	private ItemsRepository itemsRepository;

	@Override
	public Items saveItemByTypeId(
			Types typeId,
			String itemName,
			MultipartFile itemImage,
			String description,
			long offerPercentage,
			long price) throws IOException {
		Items itt=new Items();
		itt.setTypes(typeId);
		itt.setItemName(itemName);
		itt.setOfferPercantage(offerPercentage);
		itt.setPrice(price);
		itt.setDescription(description);
		itt.setItemImage(itemImage.getBytes());
		// Retrieve the associated ClientEntity from the Types
	    ClientEntity clientEntity = typeId.getClientEntity();

	    // Check if the associated ClientEntity exists
	    if (clientEntity == null) {
	        throw new ClientEntityNotfoundException("ClientEntity not found for the given Types");
	    }

	    // Set the ClientEntity to the Items
	    itt.setClientEntity(clientEntity);

		return itemsRepository.save(itt);
	}
	
	 @Override
	    public List<Items> findItemsByBusinessId(String businessId) {
	        return itemsRepository.findItemsByBusinessId(businessId);
	    }
	 @Override
	    public Items updateItem(Long itemId, String itemName, MultipartFile itemImage, String description, long offerPercentage, long price) throws IOException {
	        Optional<Items> optionalItem = itemsRepository.findById(itemId);

	        if (optionalItem.isPresent()) {
	            Items existingItem = optionalItem.get();
	            // Update existingItem with new values
	            existingItem.setItemName(itemName);
	            

	            if (itemImage != null && !itemImage.isEmpty()) {
	                existingItem.setItemImage(itemImage.getBytes());
	            }   
	            
	            existingItem.setDescription(description);
	            existingItem.setOfferPercantage(offerPercentage);
	            existingItem.setPrice(price);

	            return itemsRepository.save(existingItem);
	        } else {
	            return null; // Item not found
	        }
	    }

	    @Override
	    public boolean deleteItem(Long itemId) {
	        if (itemsRepository.existsById(itemId)) {
	            itemsRepository.deleteById(itemId);
	            return true;
	        } else {
	            return false; // Item not found
	        }
	    }
}
