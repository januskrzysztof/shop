package com.shop.services;

import com.shop.models.Cart;
import com.shop.models.Product;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
@Service
public class CartServiceImpl implements CartService {
    private static final String CART_SESSION_ID = "cart";

    public void addProductToCart(Product product, HttpSession session) {
        Cart cart = getCart(session);
        cart.addProduct(product);

        session.setAttribute(CART_SESSION_ID, cart);
    }

    public boolean hasProductInCartAlready(Product product, HttpSession session) {
        return getCart(session).hasProduct(product);
    }

    public Cart getCart(HttpSession session) {
        Cart cart;
        if (session.getAttribute(CART_SESSION_ID) instanceof Cart) {
            cart = (Cart) session.getAttribute(CART_SESSION_ID);
        } else {
            cart = new Cart();
        }

        return cart;
    }
}
