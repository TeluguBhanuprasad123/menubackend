package com.codelibary.www.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.dtos.TypesWithCatIdDTO;
import com.codelibary.www.entity.Categories;
import com.codelibary.www.entity.Types;

public interface TypeService {

	Types saveType(String typeName, MultipartFile typeImage, Categories catId) throws IOException;

	List<Types> getTypesByCategoryId( String businessId);

}
