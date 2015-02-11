package com.shop.web.controllers;

import com.shop.dao.ProductDao;
import com.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by apbudzinski on 2015-02-11.
 */

@Controller
@RequestMapping("/categories/find")
public class FindInCategoryController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView productInCategory(
            @ModelAttribute("categoryName") String categoryName,
            @ModelAttribute("productName") String productName,
            ModelAndView model, SessionStatus status) {

        List<Product> productsFoundInCategory = productDao.findProductsInCategory(categoryName, productName);
        model.addObject("productsFoundInCategory", productsFoundInCategory);

        return model;
    }
}
