package com.shop.web.controllers;

import com.shop.exceptions.DaoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
@Controller
public class RegistrationController {
    @RequestMapping("/registration")
    public String registration() throws DaoException {
        return "registration";
    }
}
