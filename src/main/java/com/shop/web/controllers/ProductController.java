package com.shop.web.controllers;

import com.shop.exceptions.DaoException;
import com.shop.models.Product;
import com.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView add() {
        return new ModelAndView("product/add", "productForm", new Product());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("productForm") Product product, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            try {
                productService.addProduct(product);
                return "redirect:/product/edit/" + product.getId();
            } catch (DaoException ex) {
                result.addError(new ObjectError("name", "Something went wrong"));
            }
        }

        model.addAttribute("productForm", product);
        return "product/add";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable int id) {
        Product product = productService.getProduct(id);
        productService.removeProduct(product);
        return new ModelAndView("product/remove");
    }

    @RequestMapping(value = "/edit/{product}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Product product) {
        return new ModelAndView("product/edit", "productForm", product);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable int id, @Valid @ModelAttribute("productForm") Product product, BindingResult result) {
        if (!result.hasErrors()) {
            try {
                product.setId(id);
                productService.updateProduct(product);
            } catch (DaoException e) {
                result.addError(new ObjectError("", "Something went wrong"));
            }
        }

        return "product/edit";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable int id) {
        Product product = productService.getProduct(id);
        ModelAndView model = new ModelAndView("product/detail");
        model.addObject("product", product);
        return model;
    }
}
