package com.quanti.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quanti.model.Category;

public class CategoryDaoTest extends BaseDaoTestCase{

	@Autowired
	private CategoryDao dao;
	
	@Test
	public void testGetAllCategories() throws Exception{
		List<Category> categories = dao.getAll();
		assertNotNull(categories);
		
		log.debug("Quantity categories: " + categories.size());		
	}
	
	@Test
	public void testGetCategoryById() throws Exception{
		Long ix = 1L;
		Category cat = dao.get(ix);
		
		assertNotNull(cat);
		assertEquals(ix, cat.getId());
		assertNotNull(cat.getName());
	}
}
