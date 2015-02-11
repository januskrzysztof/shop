package com.shop.services;

import com.shop.models.Cart;
import com.shop.models.Product;

import javax.servlet.http.HttpSession;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
public interface CartService {
    public void addProductToCart(Product cart, HttpSession session);
    public Cart getCart(HttpSession session);
}
