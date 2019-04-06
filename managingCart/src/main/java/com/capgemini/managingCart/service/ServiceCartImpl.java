package com.capgemini.managingCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.managingCart.beans.Cart;
import com.capgemini.managingCart.beans.CartProduct;
import com.capgemini.managingCart.beans.Customer;

import com.capgemini.managingCart.beans.Product;
import com.capgemini.managingCart.repo.CustomerRepo;
import com.capgemini.managingCart.repo.ICartRepo;
import com.capgemini.managingCart.repo.ProductRepo;

@Service("serviceCartImp")
@Transactional
public class ServiceCartImpl implements ICartService{
	@Autowired
	ICartRepo dao;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	CustomerRepo customerRepo;	

	public List<CartProduct> getAllProductsFromCart(String customerId){
		List<CartProduct> cartList;

		Customer customer = customerRepo.getOne(customerId);
		Cart cart=customer.getCart();
		String cartId=cart.getCart_id();
		cartList = dao.findCartDTOsByCustomer(cartId);
		return cartList; 
	}


	public CartProduct addProduct(String productId, int quantity)
	{
		Product product = productRepo.getOne(productId);
		if (product.getInitial_quantity() > quantity) {
			CartProduct cart = new CartProduct();
			cart.setQuantity(quantity);
			cart.setProduct(product);

			return dao.save(cart);
		}
		else
			return null;

	}

	public CartProduct updateCart(String customerId, String productId, int quantity){
		Customer customer = customerRepo.getOne(customerId);
		Product product = productRepo.getOne(productId);
		CartProduct cart = dao.findByCustomerAndProduct(customerId,product);


		if (product.getInitial_quantity() > quantity) {
			if(quantity!=0) {
				cart.setProduct(product);
				return dao.save(cart);
			} else {
				return null;
			}
		} else
			return null;
	}

	public CartProduct removeProductFromCart(String customerId,String productId) {
		Customer customer = customerRepo.getOne(customerId);
		Product product = productRepo.getOne(productId);
		CartProduct cart = dao.findByCustomerAndProduct(customerId, product);
		dao.deleteById(cart.getCartProductId());

		if(cart==null)
			return null;
		else
			return cart;

	}
}
