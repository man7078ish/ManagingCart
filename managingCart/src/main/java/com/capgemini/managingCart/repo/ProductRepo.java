package com.capgemini.managingCart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.managingCart.beans.Product;



@Repository
public interface ProductRepo extends JpaRepository<Product, String>{

}
