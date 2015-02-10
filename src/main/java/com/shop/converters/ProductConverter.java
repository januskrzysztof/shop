package com.shop.converters;

import com.shop.models.Product;
import com.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
@Service
public class ProductConverter implements Converter<String, Product> {
    private ProductService productService;

    @Autowired
    public ProductConverter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product convert(String str) {
        return productService.getProduct(Integer.parseInt(str));
    }
}
