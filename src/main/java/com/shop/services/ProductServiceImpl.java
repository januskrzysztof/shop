package com.shop.services;

import com.shop.dao.ProductDao;
import com.shop.exceptions.DaoException;
import com.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(Product product) throws DaoException {
        productDao.add(product);
    }

    @Override
    public Product getProduct(int id) {
        return productDao.getProduct(id);
    }
}
