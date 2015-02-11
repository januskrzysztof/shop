package com.shop.web.controllers;

import com.shop.dao.ProductDao;
import com.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ModelAndView searchProductsByCategory(@PathVariable String name, ModelAndView model) {
		List<Product> productsInCategory = productDao.findProductsByCategory(name);
		model.addObject("categoryName", name);
		model.addObject("productsInCategory", productsInCategory);
		return model;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchProductInCategory(
			@ModelAttribute("categoryName") String categoryName,
			@ModelAttribute("productName") String productName,
			ModelAndView model, SessionStatus status) {

		List<Product> productsFoundInCategory = productDao.findProductsInCategory(categoryName, productName);
		model.addObject("productsFoundInCategory", productsFoundInCategory);

		return model;
	}
}