package com.codelibary.www.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.Categories;
import com.codelibary.www.entity.ClientEntity;

public interface CategoriesService {

	Categories saveCategory(String categoryName, MultipartFile catImage, ClientEntity bussiness_id) throws IOException;

	Categories getCategoryById(long catId);

	List<Categories> getAllCategories();

	void deleteCategory(long catId);
	
	  List<Categories> getCategoriesByBusinessId(String businessId);

	  Categories saveCategory(Categories category);
}
