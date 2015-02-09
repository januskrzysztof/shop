package com.shop.web.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Krzysztof Januś on 2015-02-02.
 */
@Controller
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
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/admin")
    public String admin() {
        return "secured";
    }

    @Secured("ROLE_SUPER_ADMIN")
    @RequestMapping("/secured")
    public String secured() {
        return "secured";
    }
}
