package com.codelibary.www.service;

import com.codelibary.www.entity.Cart;

public interface CartService {
	
	
	Cart addItemToCart(long diningId, long itemId);
	public Cart decreaseItemQuantity(long diningId, long itemId, long quantity);
	 public Cart getCurrentCartByDiningId(long diningId);
}
