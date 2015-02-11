package com.shop.services;

import com.shop.exceptions.DaoException;
import com.shop.models.Category;

import java.util.List;

/**
 * Created by Wojtek on 2015-02-11.
 */
public interface CategoryService {

	public List<Category> getCategories(int offset, int limit);
	public Category getCategory(int id);
	public Category getCategoryByName(String name);
	public void remove(Category category) throws DaoException;
	public void update(Category category) throws DaoException;
	public void add(Category category) throws DaoException;

}
