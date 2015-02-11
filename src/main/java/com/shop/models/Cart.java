package com.shop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apbudzinski on 2015-02-05.
 */
public class Cart implements Serializable {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean hasProduct(Product product) {
        for (Product p : products) {
            if (product.equals(p)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
