package com.shop.web.controllers;

import com.shop.exceptions.DaoException;
import com.shop.models.Address;
import com.shop.models.Person;
import com.shop.models.User;
import com.shop.services.UserService;
import com.shop.validator.AddressValidator;
import com.shop.validator.PasswordValidator;
import com.shop.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registration() {
        User user = new User();
        user.setPerson(new Person(new Address()));

        return new ModelAndView("registration", "user", user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> model) {
        new PasswordValidator().validate(user, result);
        new AddressValidator().validate(user.getPerson().getAddress(), result);
        new PersonValidator().validate(user.getPerson(), result);

        if (!result.hasErrors()) {
            if (userService.findUserByUsername(user.getUsername()) == null) {
                try {
                    userService.registerUser(user);
                    return "redirect:/login?register-success=1";
                } catch (DaoException ex) {
                    result.addError(new ObjectError("username", "Something went wrong."));
                }
            } else {
                result.addError(new ObjectError("username", String.format("User: '%s' exists already.", user.getUsername())));
            }
        }

        model.put("user", user);
        return "registration";
    }
}
