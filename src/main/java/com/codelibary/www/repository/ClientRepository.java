package com.codelibary.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codelibary.www.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, String> {

	@Query("SELECT ce FROM ClientEntity ce WHERE ce.bussiness_id = :businessId")
	ClientEntity findByBussinessId(@Param("businessId") String businessId);

	
	   List<ClientEntity>   findAllByAdminIdAdminId(long adminId);
	
}
