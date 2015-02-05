package com.shop.dao;

import com.shop.models.Product;

import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
public interface ProductDao {
    public List<Product> getProducts(int offset, int limit);
    public Product getProduct(int id);
    public void remove(Product product);
    public void update(Product product);
    public void add(Product product);
}
