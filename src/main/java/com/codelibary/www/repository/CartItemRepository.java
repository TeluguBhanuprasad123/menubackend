package com.codelibary.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelibary.www.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
