package com.codelibary.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codelibary.www.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long>{
	 @Query(value = "SELECT * FROM categories c WHERE c.bussiness_id = :businessId", nativeQuery = true)
	    List<Categories> findByBusinessIdNative(@Param("businessId") String businessId);
	 
}
