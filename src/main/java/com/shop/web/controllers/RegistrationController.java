package com.shop.web.controllers;

import com.shop.exceptions.DaoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
@Controller
public class RegistrationController {
    @RequestMapping("/registration")
    public ModelAndView registration(ModelAndView model) throws DaoException {
        model.setViewName("registration");
        return model;
    }
}
