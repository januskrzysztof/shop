package com.shop.web.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Krzysztof Januś on 2015-02-03.
 */
@Controller
public class AuthenticateController {
    private SecurityContext context;

    public AuthenticateController() {
        context = SecurityContextHolder.getContext();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "register-success", required = false) String register,
            ModelAndView model
    ) {
        Authentication authentication = context.getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            model.setViewName("redirect:/");
            return model;
        }

        if (error != null) {
            model.addObject("error", "Invalid username and password");
        }

        if (register != null) {
            model.addObject("register_success", 1);
        }
        return model;
    }

    @Secured("ROLE_MEMBER")
    @RequestMapping(value = "/logout")
    public String logout() {
        Authentication authentication = context.getAuthentication();
        if (authentication != null) {
            authentication.setAuthenticated(false);
            SecurityContextHolder.clearContext();
        }

        SecurityContextHolder.setContext(new SecurityContextImpl());

        return "redirect:/login";
    }
}
