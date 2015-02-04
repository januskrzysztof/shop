package com.shop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Krzysztof Januś on 2015-02-02.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    /**
     * Welcome page
     */
    @RequestMapping(value = {"/", "/welcome"})
    public ModelAndView index(ModelAndView model) {
        model.setViewName("index");
        return model;
    }

    /**
     * Secured area
     */
    @RequestMapping(value = "/admin**")
    public ModelAndView secured(ModelAndView model) {
        model.setViewName("secured");

        return model;
    }
}
