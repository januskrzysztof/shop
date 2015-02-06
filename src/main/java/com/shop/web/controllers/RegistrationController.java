package com.shop.web.controllers;

import com.shop.models.User;
import com.shop.validator.PasswordValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration", "user", new User());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> model) {
        PasswordValidator validator = new PasswordValidator();

        validator.validate(user, result);

        System.out.println(result.hasErrors());
        System.out.println(user.toString());

        model.put("user", user);

        return "registration";
    }
}
