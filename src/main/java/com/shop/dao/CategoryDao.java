package com.shop.dao;

import com.shop.exceptions.DaoException;
import com.shop.models.Category;

import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
public interface CategoryDao {
    public List<Category> getCategories(int offset, int limit);
    public Category getCategory(int id);
    public void remove(Category category) throws DaoException;
    public void update(Category category) throws DaoException;
    public void add(Category category) throws DaoException;
}
