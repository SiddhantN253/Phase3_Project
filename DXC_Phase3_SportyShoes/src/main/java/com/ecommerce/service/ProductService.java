package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.BusinessException;
import com.ecommerce.model.Product;

public interface ProductService {

	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public Product getProductById(int id) throws BusinessException;
	
	public void deleteProductById(int id);
	
	public List<Product> getAllProducts();
	
	public List<Product> getProductsByBrand(String brand);
	
}