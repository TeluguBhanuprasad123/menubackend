package com.codelibary.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelibary.www.entity.Cart;
import com.codelibary.www.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addItem/{diningId}/{itemId}")
	public ResponseEntity<Cart> addItemToCart(
	        @PathVariable long diningId,
	        @PathVariable long itemId) {
	    Cart updatedCart = cartService.addItemToCart(diningId, itemId);
	    return new ResponseEntity<>(updatedCart, HttpStatus.OK);
	}
	
	@PostMapping("/decreaseItemQuantity/{diningId}/{itemId}")
    public ResponseEntity<?> decreaseItemQuantity(
    		@PathVariable long diningId,
    		@PathVariable long itemId,
            @RequestParam long quantity
    ) {
        try {
            Cart updatedCart = cartService.decreaseItemQuantity(diningId, itemId, quantity);
            return ResponseEntity.ok(updatedCart);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
     
    @GetMapping("/dining/{diningId}")
    public ResponseEntity<Cart> getCurrentCartByDiningId(@PathVariable long diningId) {
        try {
            Cart cart = cartService.getCurrentCartByDiningId(diningId);
            return ResponseEntity.ok(cart);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
