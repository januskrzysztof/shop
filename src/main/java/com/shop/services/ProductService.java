package com.shop.services;

import com.shop.exceptions.DaoException;
import com.shop.models.Product;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
public interface ProductService {
    public void addProduct(Product product) throws DaoException;
    public void updateProduct(Product product) throws DaoException;
    public Product getProduct(int id);
    public void removeProduct(Product product);
}
