package com.shop.controllers;

import com.shop.models.Category;
import com.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Krzysztof Januś on 2015-02-02.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Category category = categoryRepository.getCategoryByName("asd");
        ModelAndView model = new ModelAndView("index");
        model.addObject("category", category);

        return model;
    }
}
