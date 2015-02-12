package com.shop.services;

import com.shop.models.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
@Service
public class CartServiceImpl implements CartService {
    private static final String CART_SESSION_ID = "cart";
    private HttpSession session;

    @Override
    public void addProductToCart(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            getCart().addProduct(product);
        }
        save();
    }

    public void removeProductFromCart(Product product) {
        getCart().removeProduct(product);
        save();
    }

    public void setProductQuantity(Product product, int quantity) {
        getCart().setCartProductQuantity(product, quantity);
        save();
    }

    public void clearCart() {
        getCart().clear();
        save();
    }

    @Override
    public Cart getCart() {
        checkSession();

        Cart cart;
        if (session.getAttribute(CART_SESSION_ID) instanceof Cart) {
            cart = (Cart) session.getAttribute(CART_SESSION_ID);
        } else {
            cart = new Cart();
            session.setAttribute(CART_SESSION_ID, cart);
        }

        return cart;
    }

    public CartServiceImpl setSession(HttpSession session) {
        this.session = session;
        return this;
    }

    private void save() {
        checkSession();
        session.setAttribute(CART_SESSION_ID, getCart());
    }

    private void checkSession() {
        if (session == null) {
            throw new IllegalStateException("Session was not set.");
        }
    }
}
