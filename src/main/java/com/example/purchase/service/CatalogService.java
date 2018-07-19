package com.example.purchase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.purchase.dto.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CatalogService {
	@Autowired
	private RestTemplate rt;
	
	@HystrixCommand(fallbackMethod="defaultProduct")
	public Product findProduct(String productId) {
		Product product = rt.getForObject(
				"http://shop-catalog/api/products/{productId}", Product.class, productId);
		
		return product;
	}
	
	@HystrixCommand(fallbackMethod="defaultChangeAvProduct")
	public Product changeAvailability(String productId, int quantity) {
		Product product = rt.exchange(
				"http://shop-catalog/api/products/{productId}/availability/{quantity}", 
				HttpMethod.PUT, null, Product.class, 
				productId, -quantity).getBody();
		
		return product;
	}
	
	public Product defaultProduct(String productId) {
		Product product = new Product();
		product.setId("0000");
		product.setTitle("Unavaible");
		return product;
	}
	
	public Product defaultChangeAvProduct(String productId, int quantity) {
		Product product = new Product();
		product.setId("0000");
		product.setTitle("Unavaible");
		product.setAvailability(0);
		return product;
	}
}
