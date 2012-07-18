package com.quanti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanti.dao.CategoryDao;
import com.quanti.model.Category;
import com.quanti.service.CategoryManager;


@Service("categoryManager")
public class CategoryManagerImpl implements CategoryManager{

	@Autowired
	private CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao){
		this.categoryDao = categoryDao;
	}
	
	public List<Category> getAllCategories() {
		return categoryDao.getAll();
	}

	public Category getCategoryBy(Long id) {
		return categoryDao.get(id);		
	}

}
