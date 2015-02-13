package com.shop.web.controllers;

import com.shop.services.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {

	@Autowired
	private CartServiceImpl cartService;

	@Secured("ROLE_MEMBER")
	@RequestMapping(value = "/cart/order", method = RequestMethod.GET)
	public ModelAndView addOrder(HttpSession session) {
		ModelAndView model = new ModelAndView();
		cartService.setSession(session).getCart().clear();
		return model;
	}
}
