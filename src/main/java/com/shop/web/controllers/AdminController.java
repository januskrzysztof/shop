package com.shop.web.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView show() {
        return new ModelAndView("admin");
    }
}
