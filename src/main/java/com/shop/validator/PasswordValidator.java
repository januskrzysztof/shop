package com.shop.validator;

import com.shop.models.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Krzysztof Januś on 2015-02-06.
 */
public class PasswordValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (!(user.getPassword().equals(user.getConfirmPassword()))) {
            errors.rejectValue("confirmPassword", "notmatched.password");
        }
    }
}
