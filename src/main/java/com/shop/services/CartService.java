package com.shop.services;

import com.shop.models.Cart;
import com.shop.models.Product;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
public interface CartService {
    public void addProductToCart(Product product, int quantity);
    public void removeProductFromCart(Product product);
    public void clearCart();
    public Cart getCart();
}
