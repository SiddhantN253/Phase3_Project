package com.ecommerce.service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CategoryRepository;
import com.ecommerce.exception.BusinessException;
import com.ecommerce.model.Category;
import com.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository dao;
	
	
	@Override
	public Category addCategory(Category category) {
		
		return dao.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return dao.save(category);
	}

	@Override
	public Category getCategoryById(int id) throws BusinessException {
		if (id <= 0) {
			throw new BusinessException("The categoryId cannot be Zero or Negative. Please supply the right categoryId.");
		}
		Category category = null;
		try {
			category= dao.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new BusinessException("No category found for the given id");
		}
		return category;
		
	}

	@Override
	public void deleteCategoryCyId(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Category> getAllCategories() {
		
		return dao.findAll();
	}

}