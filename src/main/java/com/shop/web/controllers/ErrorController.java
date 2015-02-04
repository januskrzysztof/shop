package com.shop.web.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Krzysztof Januś on 2015-02-04.
 */
@Controller
public class ErrorController {
    @RequestMapping("/403")
    public String error403() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(auth.getPrincipal());

        return "errors/403";
    }
}
