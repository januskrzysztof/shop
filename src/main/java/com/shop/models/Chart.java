package com.shop.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apbudzinski on 2015-02-05.
 */
public class Chart {
    private List<Product> productsInChart = new ArrayList<>();

    public void addProduct(Product product) {
        productsInChart.add(product);
    }

    public void removeProduct(Product product) {
        if (productsInChart.contains(product)) {
            productsInChart.remove(product);
        }
    }

    public List getProducts() {
        return productsInChart;
    }
}
