package com.shop.dao;

import com.shop.models.Category;

import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
public interface CategoryDao {
    public List<Category> getCategories(int offset, int limit);
    public Category getCategory(int id);
    public void remove(Category category);
    public void update(Category category);
    public void add(Category category);
}
