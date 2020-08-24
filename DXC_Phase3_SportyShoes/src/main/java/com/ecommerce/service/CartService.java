package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.BusinessException;
import com.ecommerce.model.Cart;

public interface CartService {

	public Cart addCart(Cart cart) throws BusinessException;
	
	public Cart updateCart(Cart cart) throws BusinessException;
	
	public Cart getCartById(int id) throws BusinessException;
	
	public void deleteCartById(int id) throws BusinessException;
	
	public List<Cart> GetAllCarts() throws BusinessException;
}