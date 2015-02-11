package com.shop.web.controllers;

import com.shop.exceptions.DaoException;
import com.shop.models.Product;
import com.shop.services.CategoryService;
import com.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Krzysztof Januś on 2015-02-10.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("product/add", "productForm", new Product());
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("productForm") Product product, @ModelAttribute("categoryName") String
			categoryName, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			try {
				product.setCategory(categoryService.getCategoryByName(categoryName));
				productService.addProduct(product);
				return "redirect:/product/detail/" + product.getId();
			} catch (DaoException ex) {
				result.addError(new ObjectError("name", "Something went wrong"));
			}
		}

		model.addAttribute("productForm", product);
		return "product/add";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable int id, HttpServletRequest request) {
		Product product = productService.getProduct(id);
		productService.removeProduct(product);
		return redirect(request);
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/edit/{product}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable Product product) {
		ModelAndView model = new ModelAndView("product/edit", "productForm", product);
		model.addObject("categoryName", product.getCategory().getName());
		return model;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String edit(@PathVariable int id, @Valid @ModelAttribute("productForm") Product product,
					   @ModelAttribute("categoryName") String categoryName, BindingResult result) {
		if (!result.hasErrors()) {
			try {
				product.setId(id);
				product.setCategory(categoryService.getCategoryByName(categoryName));
				productService.updateProduct(product);
			} catch (DaoException e) {
				result.addError(new ObjectError("", "Something went wrong"));
			}
		}

		return "redirect:/product/detail/" + product.getId();
	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable int id) {
		Product product = productService.getProduct(id);
		ModelAndView model = new ModelAndView("product/detail");
		model.addObject("product", product);
		return model;
	}

	private String redirect(HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		return "redirect:" + (referer == null ? "/" : referer);
	}
}
