package com.shop.web.controllers;

import com.shop.dao.UserDao;
import com.shop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by apbudzinski on 2015-02-12.
 */

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/users")
public class ClientsController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView getUsers() {
		ModelAndView model = new ModelAndView("users/users");
		List<User> users = userDao.getUsers();
	model.addObject("users", users);
	System.out.println(users);
	return model;
}

	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	public ModelAndView getUserByName(@ModelAttribute("userLastName") String lastName) {
		ModelAndView model = new ModelAndView("users/findUser");
		List<User> users = userDao.findUserByLastName(lastName);
		model.addObject("users", users);
		System.out.println(users);
		return model;
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public ModelAndView getUserDetails(@PathVariable int id) {
		User user = userDao.getUser(id);
		ModelAndView model = new ModelAndView("users/details");
		model.addObject("user", user);
		return model;
	}

}
