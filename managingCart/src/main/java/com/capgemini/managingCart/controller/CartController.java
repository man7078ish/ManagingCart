package com.capgemini.managingCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.managingCart.beans.CartProduct;

import com.capgemini.managingCart.service.ICartService;

@RestController
public class CartController {
	@Autowired
	ICartService customerService;
	
	
	public ICartService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(ICartService customerService) {
		this.customerService = customerService;
	}
	@RequestMapping(value= "/addProductToNewCart")
	public CartProduct addProductToNewCart(int quantity, String productId) { 
		CartProduct cart=null;
		try {
			cart= customerService.addProduct(productId, quantity);
		}
		catch  (Exception e) {
			return cart;
		}
		return cart;
	}
	@RequestMapping(value= "/updateCart")
	public CartProduct updateCart(String customerId,int quantity, String productId) {
		CartProduct cart=null;
		try {
			cart = customerService.updateCart(customerId, productId, quantity);
		} catch (Exception e) {
			return cart;
		}
		
		return cart;
	}
	@RequestMapping(value= "/removeFromCart")
	public CartProduct removeFromCart(String customerId,String productId) {
		
		return customerService.removeProductFromCart(customerId, productId);
	}
	@RequestMapping(value= "/getCart")
	public List<CartProduct> getCart(String customerId) {
		List<CartProduct> cartList = null;
		
			cartList = customerService.getAllProductsFromCart(customerId);
		
		
		return cartList;
	}
}
