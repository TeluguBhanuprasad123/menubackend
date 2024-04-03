package com.codelibary.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codelibary.www.entity.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
	@Query(value = "SELECT * FROM departments d WHERE d.bussiness_id = :businessId", nativeQuery = true)
	List<Departments> findByBusinessIdNative(@Param("businessId") String businessId);


}
