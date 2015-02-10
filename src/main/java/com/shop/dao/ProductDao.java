package com.shop.dao;

import com.shop.exceptions.DaoException;
import com.shop.models.Product;

import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
public interface ProductDao {
    public List<Product> findProductsByName(String name);
    public List<Product> getProducts(int offset, int limit);
    public List<Product> findProductsByCategory(String categoryName);
    public Product getProduct(int id);
    public void remove(Product product) throws DaoException;
    public void update(Product product) throws DaoException;
    public void add(Product product) throws DaoException;
}
