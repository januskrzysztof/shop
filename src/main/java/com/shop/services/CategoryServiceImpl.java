package com.shop.services;

import com.shop.dao.CategoryDao;
import com.shop.exceptions.DaoException;
import com.shop.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wojtek on 2015-02-11.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;

	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}


	@Override
	public List<Category> getCategories(int offset, int limit) {
		return categoryDao.getCategories(offset, limit);
	}

	@Override
	public Category getCategory(int id) {
		return categoryDao.getCategory(id);
	}

	@Override
	public Category getCategoryByName(String name) {
		return categoryDao.getCategoryByName(name);
	}

	@Override
	public void remove(Category category) throws DaoException {
		categoryDao.remove(category);
	}

	@Override
	public void update(Category category) throws DaoException {
		categoryDao.update(category);
	}

	@Override
	public void add(Category category) throws DaoException {
		categoryDao.add(category);
	}
}
