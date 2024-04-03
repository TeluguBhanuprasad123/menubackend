package com.codelibary.www.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.DiningTable;
import com.google.zxing.WriterException;

public interface DinningtableService {
	
	
	DiningTable save(String tableName,ClientEntity businessId) throws WriterException, IOException;
	 List<DiningTable> getAllDiningTables();
	    DiningTable getDiningTableById(Long tableId);
	    DiningTable updateDiningTable(Long tableId, DiningTable diningTable);
	    void deleteDiningTable(Long tableId);
	    List<DiningTable> findByBusinessIdNative(String businessId);
	    Optional<DiningTable> findByBusinessIdAndTableId(String businessId, Long tableId);
}
