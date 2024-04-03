package com.codelibary.www.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.DiningTable;
import com.codelibary.www.service.DinningtableService;
import com.google.zxing.WriterException;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/DinningTable")
public class DinningController {
	
	@Autowired
	private DinningtableService dinningtableService;
	
	@PostMapping("/save/{businessId}")
	public ResponseEntity<DiningTable> savedining(@RequestParam String tableName,@PathVariable  ClientEntity businessId) throws WriterException, IOException{
		DiningTable sd=dinningtableService.save(tableName, businessId);
		return new ResponseEntity<>(sd,HttpStatus.OK);
		
	}
	
	
	@GetMapping
    public ResponseEntity<List<DiningTable>> getAllDiningTables() {
        List<DiningTable> diningTables = dinningtableService.getAllDiningTables();
        return new ResponseEntity<>(diningTables, HttpStatus.OK);
    }

    @GetMapping("/{tableId}")
    public ResponseEntity<DiningTable> getDiningTableById(@PathVariable Long tableId) {
        DiningTable diningTable = dinningtableService.getDiningTableById(tableId);
        if (diningTable != null) {
            return new ResponseEntity<>(diningTable, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

  

    @PutMapping("/{tableId}")
    public ResponseEntity<DiningTable> updateDiningTable(@PathVariable Long tableId, @RequestParam DiningTable diningTable) {
        DiningTable updatedDiningTable = dinningtableService.updateDiningTable(tableId, diningTable);
        if (updatedDiningTable != null) {
            return new ResponseEntity<>(updatedDiningTable, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{tableId}")
    public ResponseEntity<Void> deleteDiningTable(@PathVariable Long tableId) {
    	dinningtableService.deleteDiningTable(tableId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
    @GetMapping("/findByBusinessIdNative/{businessId}")
    public ResponseEntity<List<DiningTable>> findByBusinessIdNative(@PathVariable String businessId) {
        List<DiningTable> diningTables = dinningtableService.findByBusinessIdNative(businessId);
        return new ResponseEntity<>(diningTables, HttpStatus.OK);
    }
	
    @GetMapping("/{businessId}/{tableId}")
    public ResponseEntity<DiningTable> getDiningTable(
            @PathVariable("businessId") String businessId,
            @PathVariable("tableId") Long tableId) {

        Optional<DiningTable> diningTable = dinningtableService.findByBusinessIdAndTableId(businessId, tableId);

        return diningTable.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
