package com.capgemini.managingCart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.managingCart.beans.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, String>{

//	@Query("SELECT m FROM customerdetail m WHERE m.email =:email")
//	@Query("SELECT m FROM customerdetail m")
//	public Customer findByCustomerEmail(@Param("email")String customerEmail);

}
