package com.codelibary.www.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelibary.www.entity.Cart;
import com.codelibary.www.entity.DiningTable;

public interface CartRepository extends JpaRepository<Cart,Long> {
	   Optional<Cart> findByDiningTable_TableId(long tableId);

}
