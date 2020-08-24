package com.ecommerce.service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CartRepository;
import com.ecommerce.exception.BusinessException;
import com.ecommerce.model.Cart;
import com.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository dao;
	
	@Override
	public Cart addCart(Cart cart) throws BusinessException {
		Cart cart2=null;
		try {
			cart2=dao.save(cart2);
		} catch(Exception e) {
			throw new BusinessException("Unable to add the cart, please check user input");
		}
		return cart2;
	}

	@Override
	public Cart updateCart(Cart cart) throws BusinessException {
		Cart cart2=null;
		try {
			cart2=dao.save(cart2);
		} catch(Exception e) {
			throw new BusinessException("Unable to update the cart, please check user input");
		}
		return cart2;
	}
	

	@Override
	public Cart getCartById(int id) throws BusinessException {
		
		if (id <= 0) {
			throw new BusinessException("The cartId cannot be Zero or Negative. Please give the right cartId.");
		}
		Cart cart = null;
		try {
			cart=dao.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new BusinessException("No cart found for the given id");
		}
		return cart;
	}

	@Override
	public void deleteCartById(int id) throws BusinessException {
		if (id <= 0) {
			throw new BusinessException("The cartId cannot be Zero or Negative. Please give the right cartId.");
		}
		Cart cart = null;
		try {
			dao.deleteById(id);
		} catch (NoSuchElementException e) {
			throw new BusinessException("No cart found for the given id");
		}
	}

	@Override
	public List<Cart> GetAllCarts() {
		
		return null;
	}

}
