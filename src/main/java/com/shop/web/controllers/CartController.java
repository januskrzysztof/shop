package com.shop.web.controllers;

import com.shop.models.Product;
import com.shop.services.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartServiceImpl cartService;

	@Secured("ROLE_MEMBER")
	@RequestMapping(value = "/add/{product}/{quantity}", method = RequestMethod.GET)
	public String add(@PathVariable Product product, @PathVariable int quantity, HttpServletRequest request,
					  HttpSession session) {
		System.out.println(quantity);
		cartService.setSession(session).addProductToCart(product, quantity);
		return redirect(request);
	}

	@Secured("ROLE_MEMBER")
	@RequestMapping(value = "/remove/{product}", method = RequestMethod.GET)
	public String remove(@PathVariable Product product, HttpServletRequest request, HttpSession session) {
		cartService.setSession(session).removeProductFromCart(product);
		return redirect(request);
	}

	@Secured("ROLE_MEMBER")
	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public String clear(HttpServletRequest request, HttpSession session) {
		cartService.setSession(session).clearCart();
		return redirect(request);
	}

	@Secured("ROLE_MEMBER")
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(HttpSession session, Model model) {
		model.addAttribute("cart", cartService.setSession(session).getCart());
		return "cart/checkout";
	}

	/**
	 * Redirect to previous page (based on user request) or if not exists then redirect to "/" (base url)
	 *
	 * @return String
	 */
	private String redirect(HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		return "redirect:" + (referer == null ? "/" : referer);
	}
}
