package com.shop.validator;

import com.shop.models.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required.passwordConfirm", "Field name is required");

        User user = (User) o;
        if (!(user.getPassword().equals(user.getConfirmPassword()))) {
            errors.rejectValue("password", "notmatched.password");
        }
    }
}
