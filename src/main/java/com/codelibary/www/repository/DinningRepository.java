package com.codelibary.www.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codelibary.www.entity.DiningTable;

public interface DinningRepository extends JpaRepository<DiningTable, Long> {
	
	 @Query(value = "SELECT * FROM dining_table c WHERE c.bussiness_id = :businessId", nativeQuery = true)
	    List<DiningTable> findByBusinessIdNative(@Param("businessId") String businessId);

	 @Query("SELECT dt FROM DiningTable dt WHERE dt.clientEntity.bussiness_id = :businessId AND dt.tableId = :tableId")
	 Optional<DiningTable> findByBusinessIdAndTableId(@Param("businessId") String businessId, @Param("tableId") Long tableId);


}
