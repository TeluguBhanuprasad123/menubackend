package com.codelibary.www.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.Items;
import com.codelibary.www.entity.Types;

public interface ItemsService {
	
	Items saveItemByTypeId(Types typeId, String itemName, MultipartFile itemImage, String description, long offerPercentage, long price) throws IOException;
	 List<Items> findItemsByBusinessId(String businessId);
	 
	   Items updateItem(Long itemId, String itemName, MultipartFile itemImage, String description, long offerPercentage, long price) throws IOException;

	    boolean deleteItem(Long itemId);
}
