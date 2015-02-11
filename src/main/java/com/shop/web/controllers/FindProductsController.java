package com.shop.web.controllers;

import com.shop.dao.ProductDao;
import com.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product/search")
public class FindProductsController {
	@Autowired
	ProductDao productDao;

	@RequestMapping(method = RequestMethod.GET)
	public void searchProduct() {

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView searchProduct(@ModelAttribute("productName") String productName, @ModelAttribute
			("categoryName") String categoryName, ModelAndView model,
									  SessionStatus status) {
		List<Product> products;

		if ("all".equals(categoryName)) {
			products = productDao.findProductsByName(productName);
		} else {
			products = productDao.findProductsInCategory(categoryName, productName);
		}

		model.addObject("products", products);
		return model;
	}
}