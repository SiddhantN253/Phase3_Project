package com.ecommerce.service;


import java.util.List;

import com.ecommerce.exception.BusinessException;
import com.ecommerce.model.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Category getCategoryById(int id) throws BusinessException;
	
	public void deleteCategoryCyId(int id);
	
	public List<Category> getAllCategories();
	
	 
	
	
}