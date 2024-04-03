package com.codelibary.www.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.Categories;
import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.repository.CategoriesRepository;
import com.codelibary.www.service.CategoriesService;

@Service
public class CategoriesServiceimpl implements CategoriesService{
	
	@Autowired
	private CategoriesRepository categoriesRepository;

	@Override
	public Categories saveCategory(
			String categoryName, 
			MultipartFile catImage,
			ClientEntity bussiness_id) throws IOException {
		Categories  catSave=new Categories();
		
		catSave.setCategoryName(categoryName);
		catSave.setCatImage(catImage.getBytes());
		catSave.setClientEntity(bussiness_id);
		return categoriesRepository.save(catSave);
	}

	@Override
	public Categories getCategoryById(long catId) {

		return categoriesRepository.findById(catId).get();
	}

	@Override
	public List<Categories> getAllCategories() {

		return null;
	}

	@Override
	public void deleteCategory(long catId) {

		
	}
	
    @Override
    public List<Categories> getCategoriesByBusinessId(String businessId) {
        return categoriesRepository.findByBusinessIdNative(businessId);
    }

	@Override
	public Categories saveCategory(Categories category) {
		// TODO Auto-generated method stub
		return categoriesRepository.save(category);
	}
	
	
	

}
