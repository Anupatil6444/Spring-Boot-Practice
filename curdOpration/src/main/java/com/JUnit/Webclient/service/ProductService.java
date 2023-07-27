package com.JUnit.Webclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JUnit.Webclient.entity.Product;
import com.JUnit.Webclient.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product)
	{
		return repository.save(product);
	}
	 
	public List<Product> saveProducts(List<Product> products)
	{
		return repository.saveAll(products);
	}
	

	public List<Product> getProducts()
	{
		List<Product> product =repository.findAll();
		System.out.println("Hello...");
		return product;
	}
	
	public Product getProductById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	/*
	 * public Product getProductByName(String name) {
	 * 
	 * return repository.findByName(name); }
	 */
	
	
	public Product updateById(int id)
	{
		Product p=null;
	 p=(Product)repository.findById(id).orElse(null);
	 return p;
	}
	public String deleteProduct(int id)
	{
		repository.deleteById(id);
		return "Product removed "+id;
	}
	
}
