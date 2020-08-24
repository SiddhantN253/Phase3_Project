package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.BusinessException;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	private MultiValueMap<String, String> map;

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	 @GetMapping("/product/{id}")
	 public ResponseEntity<Product> getProductById(@PathVariable int id) {
		 try {
				return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
			} catch (BusinessException e) {
				map=new LinkedMultiValueMap<>() ;
				map.add("ErrorMessage", e.getMessage());
				return new ResponseEntity<>(null,map, HttpStatus.NOT_FOUND);
			}}

	@DeleteMapping("/product/{id}")
	public void deleteProductById(@PathVariable int id) {
		
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	
	public List<Product> getProductsByBrand(String brand) {
		
		return null;
	}
}