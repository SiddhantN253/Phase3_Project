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
import com.ecommerce.model.Cart;
import com.ecommerce.service.CartService;


@RestController
public class CartController {

	@Autowired
	private CartService service;
	
	private MultiValueMap<String, String> map;
	
	@PostMapping("/cart")
	public Cart addCart(@RequestBody Cart cart) {
		
		try {
			return service.addCart(cart);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}

	@PutMapping("/cart")
	public Cart updateCart(@RequestBody Cart cart) {
		
		try {
			return service.updateCart(cart);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}

	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable int id) {
		
		try {
			return new ResponseEntity<>(service.getCartById(id), HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>() ;
			map.add("ErrorMessage", e.getMessage());
			return new ResponseEntity<>(null,map, HttpStatus.NOT_FOUND);
		}
			
	}

	@DeleteMapping("/cart/{id}")
	public void deleteCartById(@PathVariable int id) {
	
		try {
			service.deleteCartById(id);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/carts")
	public List<Cart> GetAllCarts() throws BusinessException {
		
		return service.GetAllCarts();
	}

}