package com.shop.web.controllers;

import com.shop.dao.UserDao;
import com.shop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by apbudzinski on 2015-02-12.
 */

@Controller
@RequestMapping("/admin")
public class AdminFindUserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        ModelAndView model = new ModelAndView("users");
        List<User> users  = userDao.getUsers();
        model.addObject("users",users);
        return model;
    }

    @RequestMapping (value="/usersSearch", method = RequestMethod.POST)
    public ModelAndView getUserByName(@ModelAttribute("userLastName") String lastName, ModelAndView model,
                                      SessionStatus status) {
        User user = userDao.findUserByLastName(lastName);
        model.addObject("user",user);
        return model;
    }
}
