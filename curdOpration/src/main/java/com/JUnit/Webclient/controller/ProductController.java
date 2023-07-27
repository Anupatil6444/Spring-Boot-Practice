package com.JUnit.Webclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.JUnit.Webclient.repository.ProductRepository;
import com.JUnit.Webclient.entity.Product;
import com.JUnit.Webclient.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	private ProductRepository repository;
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product)
	{
		return service.saveProduct(product);
	}
	@PostMapping("/addproducts")
	public List<Product> addProducts(@RequestBody List<Product> products)
	{
		return service.saveProducts(products);
	}
	@GetMapping("/products")
	public List<Product> findAllProducts()
	{
		
		List<Product> product=service.getProducts();
		return product;
	}
	@GetMapping("/productid/{id}")
	public Product findProductById(@PathVariable("id") int id)
	{
		return service.getProductById(id);
	}
	
	/*
	 * @GetMapping("/productname/{name}") public Product
	 * findProductByName(@PathVariable("name") String name) {
	 * 
	 * return service.getProductByName(name); }
	 */
	
	@RequestMapping("/update/{id}")
	public Product updateProduct(@PathVariable("id") int id)
	{
		return service.updateById(id);
	}
	/*
	 * public ResponseEntity<Product> updateEmployee(@PathVariable long
	 * id,@RequestBody Product product) { Product updateEmployee =
	 * repository.findById((int) id) .orElseThrow();
	 * 
	 * updateEmployee.setName(product.getName());
	 * updateEmployee.setQuantity(product.getQuantity());
	 * updateEmployee.setPrice(product.getPrice());
	 * 
	 * repository.save(updateEmployee);
	 * 
	 * return ResponseEntity.ok(updateEmployee); }
	 */
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id)
	{
		return service.deleteProduct(id);
	}
}
