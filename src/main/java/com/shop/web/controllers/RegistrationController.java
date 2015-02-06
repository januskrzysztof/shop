package com.shop.web.controllers;

import com.shop.dao.repository.UserRepository;
import com.shop.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/registration")
    public String registration() throws DaoException {
        System.out.println(userRepository.findUserByUsername("user"));

        return "registration";
    }
}
