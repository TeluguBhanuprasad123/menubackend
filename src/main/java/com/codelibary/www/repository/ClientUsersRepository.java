package com.codelibary.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codelibary.www.entity.ClientUsers;

public interface ClientUsersRepository  extends JpaRepository<ClientUsers, Long> {


	@Query(value = "SELECT * FROM clientuser d WHERE d.bussiness_id = :businessId", nativeQuery = true)
	List<ClientUsers> findByBusinessIdNative(@Param("businessId") String businessId);
}
