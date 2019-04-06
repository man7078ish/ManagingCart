package com.capgemini.managingCart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.managingCart.beans.Cart;
import com.capgemini.managingCart.beans.CartProduct;
import com.capgemini.managingCart.beans.Customer;
import com.capgemini.managingCart.beans.Product;


@Repository
public interface ICartRepo extends JpaRepository<CartProduct, String>{

	@Query("SELECT m FROM CartProduct m WHERE m.CartProductId =:cartId")
	public List<CartProduct> findCartDTOsByCustomer(@Param("cartId")String cartId);
	
	@Query("SELECT m FROM CartProduct m WHERE m.CartProductId =:cartId AND m.product =:product")
	public CartProduct findByCustomerAndProduct(
			@Param("cartId")String cartId,@Param("product")Product product);

}
