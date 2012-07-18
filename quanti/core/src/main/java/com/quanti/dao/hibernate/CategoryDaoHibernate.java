package com.quanti.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.quanti.dao.CategoryDao;
import com.quanti.model.Category;

@Repository("categoryDao")
public class CategoryDaoHibernate extends GenericDaoHibernate<Category, Long> implements CategoryDao{

	public CategoryDaoHibernate() {
		super(Category.class);
	}

}
