package com.codelibary.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codelibary.www.entity.Types;

public interface TypesRepoisotry  extends JpaRepository<Types, Long>{
	@Query("SELECT t FROM Types t JOIN t.categories c JOIN c.clientEntity ce WHERE ce.bussiness_id = :businessId")
	List<Types> findAllByBusinessId(@Param("businessId") String businessId);

}