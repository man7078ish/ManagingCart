package com.capgemini.managingCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.capgemini.managingCart")
@EntityScan(basePackages="com.capgemini.managingCart.beans")
public class ManagingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagingCartApplication.class, args);
	}

}
