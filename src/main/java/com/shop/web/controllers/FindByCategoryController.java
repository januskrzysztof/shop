package com.shop.web.controllers;

import com.shop.dao.CategoryDao;
import com.shop.dao.ProductDao;
import com.shop.exceptions.DaoException;
import com.shop.models.Category;
import com.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apbudzinski on 2015-02-10.
 */
@Controller
@RequestMapping ("/searchByCategory")
public class FindByCategoryController {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView searchCategory() {
        ModelAndView model = new ModelAndView("searchByCategory");
        model.addObject("categoryName","");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView searchCategory(@ModelAttribute("categoryName") String categoryName ,ModelAndView model,SessionStatus status) {
        //initialize();
        List<Product> productsInCategory = productDao.findProductsByCategory(categoryName);
        model.addObject("productsInCategory", productsInCategory);

        return model;
    }



    private void initialize() {
        List<Product> products = new ArrayList<>();
        Category c = new Category();
        c.setName("books");
        Category c1 = new Category();
        c1.setName("games");
        try {
            categoryDao.add(c);
            categoryDao.add(c1);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        Product p = new Product();
        Product p1 = new Product();
        p.setName("Book1");
        p.setNetPrice(124);
        p.setCategory(c);
        p1.setName("Book2");
        p1.setNetPrice(321);
        p1.setCategory(c1);
        // ProductDao productDao = new ProductRepository();
        products.add(p);
        products.add(p1);
        Product p2 = new Product();
        p2.setName("Book3");
        p2.setNetPrice(125);
        p2.setCategory(c);
        try {
            productDao.add(p);
            productDao.add(p1);
            productDao.add(p2);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
