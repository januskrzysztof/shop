package com.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Krzysztof Januś on 2015-02-03.
 */
@Controller
public class AuthenticateController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login() { }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout() {}
}
