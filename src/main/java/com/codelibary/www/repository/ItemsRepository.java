package com.codelibary.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codelibary.www.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Long> {
	
	@Query("SELECT i FROM Items i WHERE i.clientEntity.bussiness_id = :businessId")
	List<Items> findItemsByBusinessId(@Param("businessId") String businessId);

}
