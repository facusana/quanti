package com.quanti.service;

import java.util.List;

import com.quanti.model.Category;

public interface CategoryManager {

	public List<Category> getAllCategories();
	
	public Category getCategoryBy(Long id);
	
}
