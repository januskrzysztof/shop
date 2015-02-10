package com.shop.web.controllers;

import com.shop.exceptions.DaoException;
import com.shop.models.Product;
import com.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {

        Product product = new Product();

        product.setName("asd");
        product.setNetPrice(123);
        product.setDescription("asd");


        try {
            productService.addProduct(product);
        } catch (DaoException e) {
            e.printStackTrace();
        }


        return "product/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("productForm")Product product) {
        return "product/add";
    }
}
