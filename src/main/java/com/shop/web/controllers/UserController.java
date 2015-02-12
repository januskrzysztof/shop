package com.shop.web.controllers;

import com.shop.exceptions.DaoException;
import com.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Secured("ROLE_MEMBER")
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public ModelAndView userInfo() {
		String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		System.out.println("asdasd");
		com.shop.models.User user = userService.findUserByUsername(username);
		ModelAndView model = new ModelAndView("account", "userForm", user);
		return model;
	}

	@Secured("ROLE_MEMBER")
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("userForm") com.shop.models.User user, BindingResult result) {
		System.out.println("tuuuu");

		for (Object object : result.getAllErrors()) {
			if(object instanceof FieldError) {
				FieldError fieldError = (FieldError) object;

				System.out.println(fieldError.getObjectName() + fieldError.getCode());
			}

			if(object instanceof ObjectError) {
				ObjectError objectError = (ObjectError) object;

				System.out.println(objectError.getCode());
			}
		}

		if (!result.hasErrors()) {
			try {
				userService.update(user);
			} catch (DaoException e) {
				result.addError(new ObjectError("", "Something went wrong"));
			}
		}

		return "redirect:/account";
	}

}
