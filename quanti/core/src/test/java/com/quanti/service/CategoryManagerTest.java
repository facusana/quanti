package com.quanti.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import com.quanti.model.Category;

public class CategoryManagerTest extends BaseManagerTestCase{
	private Log log = LogFactory.getLog(CategoryManagerTest.class);
	
	@Autowired
	private CategoryManager categoryManager;
	
	@Test
	public void testGetAllCategories() throws Exception{
		List<Category> categories = categoryManager.getAllCategories();
		assertNotNull(categories);
		
		log.debug("Quantity categories: " + categories.size());
	}
	
	@Test
	public void testGetCategoryById() throws Exception{
		Long ix = 1L;
		Category cat = categoryManager.getCategoryBy(ix);
		assertNotNull(cat);
		assertEquals(ix, cat.getId());
		assertNotNull(cat.getName());
	}
	
	@Test
	@ExpectedException(DataAccessException.class)
	public void testGetCategoryByWrongId() throws Exception{
		//should throw an exception
		categoryManager.getCategoryBy(-1L);		
	}
	
}
