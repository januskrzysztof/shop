package com.shop.web.controllers;

import com.shop.models.Product;
import com.shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/add/{product}", method = RequestMethod.GET)
    public String add(@PathVariable Product product, HttpSession session) {
        cartService.addProductToCart(product, session);

        System.out.println(session.getAttribute("cart"));

        return "redirect:/";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout(HttpSession session) {
        System.out.println(cartService.getCart(session));

        return "cart/checkout";
    }
}
