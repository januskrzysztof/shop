package com.shop.web.controllers;

import com.shop.dao.ProductDao;
import com.shop.exceptions.DaoException;
import com.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product/search")
public class FindProductsController{
    @Autowired
    ProductDao productDao;

    @RequestMapping(method = RequestMethod.GET)
    public void searchProduct(){

    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView searchProduct(@ModelAttribute("productName") String productName ,ModelAndView model, SessionStatus status){
        //uncomment for test data
//       initialize();

        List<Product> products = productDao.findProductsByName(productName);
        model.addObject("products",products);
        return model;
    }


    private void initialize() {
        List<Product> products = new ArrayList<>();
        Product p = new Product();
        Product p1 = new Product();
        p.setName("Book1");
        p.setNetPrice(124);
        p1.setName("Book2");
        p1.setNetPrice(321);
       // ProductDao productDao = new ProductRepository();
        products.add(p);
        products.add(p1);
        try {
            productDao.add(p);
            productDao.add(p1);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

}