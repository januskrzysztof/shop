package com.shop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by wchuchla on 2015-02-09.
 */
public class NameConstraintValidator implements ConstraintValidator<Name, String> {
    @Override
    public void initialize(Name name) {

    }

    @Override
    public boolean isValid(String nameField, ConstraintValidatorContext constraintValidatorContext) {
        if(nameField == null) {
            return false;
        }
        return nameField.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
    }
}
