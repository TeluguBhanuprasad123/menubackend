package com.codelibary.www.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelibary.www.entity.Cart;
import com.codelibary.www.entity.CartItem;
import com.codelibary.www.entity.Items;
import com.codelibary.www.repository.CartRepository;
import com.codelibary.www.repository.ItemsRepository;
import com.codelibary.www.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

//	@Autowired
//	private CartItemRepository cartItemRepository;

	@Autowired
	private ItemsRepository itemsRepository;

	  @Override
	    public Cart addItemToCart(long diningId, long itemId) {
	        // Assuming you have a method to get the current user's cart based on diningId
	        Cart cart = getCurrentUserCartByDiningId(diningId);

	        // Get the item based on itemId
	        Items item = itemsRepository.findById(itemId)
	                .orElseThrow(() -> new RuntimeException("Item not found"));

	        // Check if the item is already in the cart
	        CartItem existingCartItem = getCartItemByItemId(cart, itemId);

	        if (existingCartItem != null) {
	            // Item already in the cart, update quantity and price
	            existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
	            existingCartItem.setPrice(existingCartItem.getPrice() + item.getPrice());
	        } else {
	            // Item not in the cart, create a new CartItem
	            CartItem newCartItem = new CartItem();
	            newCartItem.setQuantity(1);
	            newCartItem.setPrice(item.getPrice());
	            newCartItem.setDiningID(diningId);
	            newCartItem.setCart(cart);
	            newCartItem.setItems(item);

	            // Add the new CartItem to the cart's list
	            cart.getCartItems().add(newCartItem);
	        }

	        // Update total price and total item count in the cart
	        updateCartTotals(cart);

	        // Save the cart to persist changes
	        return cartRepository.save(cart);
	    }
	  
	  
	  @Override
	  public Cart decreaseItemQuantity(long diningId, long itemId, long quantity) {
	      Cart cart = getCurrentUserCartByDiningId(diningId);
	      Items item = itemsRepository.findById(itemId)
	              .orElseThrow(() -> new RuntimeException("Item not found"));

	      CartItem existingCartItem = getCartItemByItemId(cart, itemId);

	      if (existingCartItem != null) {
	          // Ensure the quantity to decrease is not more than the current quantity
	          int newQuantity = Math.max((int) (existingCartItem.getQuantity() - quantity), 0);

	          // Calculate the change in quantity and update price
	          int quantityChange = (int) (existingCartItem.getQuantity() - newQuantity);
	          double priceChange = quantityChange * item.getPrice();

	          existingCartItem.setQuantity(newQuantity);
	          existingCartItem.setPrice(existingCartItem.getPrice() - priceChange);

	          // Update total item count in the cart
	          cart.setTotalItem(cart.getTotalItem() - quantityChange);
	      } else {
	          // Item not in the cart, handle accordingly (you can throw an exception or ignore)
	          throw new RuntimeException("Item not found in the cart");
	      }

	      updateCartTotals(cart);
	      return cartRepository.save(cart);
	  }


	    private void updateCartTotals(Cart cart) {
	        double totalPrice = 0;
	        int totalItem = 0;

	        for (CartItem cartItem : cart.getCartItems()) {
	            totalPrice += cartItem.getPrice();
	            totalItem += cartItem.getQuantity();
	        }

	        cart.setTotalPrice(totalPrice);
	        cart.setTotalItem(totalItem);
	    }

	    private CartItem getCartItemByItemId(Cart cart, long itemId) {
	        for (CartItem cartItem : cart.getCartItems()) {
	            if (cartItem.getItems().getItID() == itemId) {
	                return cartItem;
	            }
	        }
	        return null;
	    }

	 
	    private Cart getCurrentUserCartByDiningId(long diningId) {
	       
	        return cartRepository.findByDiningTable_TableId(diningId)
	                .orElseThrow(() -> new RuntimeException("Cart not found"));
	    }
	    
	    @Override
	    public Cart getCurrentCartByDiningId(long diningId) {
		       
	        return cartRepository.findByDiningTable_TableId(diningId)
	                .orElseThrow(() -> new RuntimeException("Cart not found"));
	    }
}
