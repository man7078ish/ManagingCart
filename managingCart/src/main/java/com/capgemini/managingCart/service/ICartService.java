package com.capgemini.managingCart.service;

import java.util.List;

import com.capgemini.managingCart.beans.Cart;
import com.capgemini.managingCart.beans.CartProduct;


public interface ICartService {
	public List<CartProduct> getAllProductsFromCart(String customerId);
	public CartProduct addProduct(String productId, int quantity);
	public CartProduct updateCart(String customerId, String productId, int quantity);
	public CartProduct removeProductFromCart(String customerId,String productId);
}
