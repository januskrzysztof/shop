package com.shop.web.controllers;

import com.shop.dao.RoleDao;
import com.shop.dao.UserDao;
import com.shop.exceptions.DaoException;
import com.shop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
@Controller
public class RegistrationController {
    @Autowired
    @Qualifier("userRepository")
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    @RequestMapping("/registration")
    public ModelAndView registration(ModelAndView model) {
        model.setViewName("registration");

        User user = userDao.getUser(7);
        user.setEnabled(true);

        try {
            userDao.remove(user);
        } catch (DaoException e) {
            e.printStackTrace();
            model.addObject("error", e.getMessage());
        }


        return model;
    }
}
