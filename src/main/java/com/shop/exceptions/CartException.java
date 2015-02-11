package com.shop.exceptions;

import com.shop.models.Product;

/**
 * Created by Krzysztof Januś on 2015-02-11.
 */
public class CartException extends RuntimeException {
    public CartException() {
    }

    public CartException(String message) {
        super(message);
    }

    public static CartException createCartProductNotFound(Product product) {
        return new CartException("Product not found: "+product);
    }
}
