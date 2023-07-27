package com.JUnit.Webclient;

import com.JUnit.Webclient.entity.*;
import com.JUnit.Webclient.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.handler.codec.http.HttpHeaders;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.JUnit.Webclient.controller.ProductController;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class CurdOprationApplicationTests {

	private ProductController productController;
	private ProductService service;

	@Test
	void contextLoads() {
	}

	WebClient webClient = WebClient.create("http://localhost:9193/");
	private Product product;
	
	Gson gson = new Gson();

	@Order(1)
	@Test
	public void addProduct() {
		
		Product product = new Product();
		
		product.setId(5);
		product.setName("Keyboard");
		product.setPrice(1200);
		product.setQuantity(4);
		
		//String json = gson.toJson(product);
		
	 Product addProduct = webClient.post().uri("/addproduct")
			   // .body(BodyInserters.fromValue(json)) 
			    .body(Mono.just(product), Product.class)
				.accept(MediaType.APPLICATION_JSON) 
				.retrieve().bodyToMono(Product.class)
				.block();
		
		assertNotNull(addProduct);
		
	}

	@Test
	public void getProducts() {

		Flux<Product> getProducts = webClient.get()
									.uri("/products")
									.retrieve()
									.bodyToFlux(Product.class);

		assertNotNull(getProducts);
	}

	
	   @Test
	  public void getProductById() { 
		   int id =101;
		  Product getProductById =webClient.get() 
				   .uri("/product/"+id) 
				   .retrieve()
	               .bodyToMono(Product.class).block();
		   
		   assertNotNull(getProductById);
	   
	   }
	 

	@Test
	public void updateProductById() {
		int id=102;
		Mono<Product> updateProduct = webClient.put()
				.uri("/update/"+id)
				.retrieve()
				.bodyToMono(Product.class);
		
		assertNotNull(updateProduct);
	}

	@Test
	public void deleteProductById() {
		int id = 0;
		String deleteProduct = webClient.delete().uri("/delete/" + id).retrieve().bodyToMono(String.class).block();
		
		System.out.println("Given String is :"+deleteProduct);
		
		assertEquals("Product removed 0", deleteProduct);
	}
}
