package com.JUnit.Webclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JUnit.Webclient.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	//Product findByName(String name);

}
