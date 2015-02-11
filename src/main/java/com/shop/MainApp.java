package com.shop;

import com.shop.models.Cart;
import com.shop.models.Product;

/**
 * Created by Krzysztof Januś on 2015-02-02.
 */
public class MainApp {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Product product = new Product();
        product.setId(1);
        product.setName("asd");
        product.setNetPrice(1223);
        cart.addProduct(product);

        product = new Product();
        product.setId(2);
        product.setName("asd");
        product.setNetPrice(1223);
        cart.addProduct(product);

        cart.setCartProductQuantity(product, 20);

        System.out.println(cart);
    }
}
