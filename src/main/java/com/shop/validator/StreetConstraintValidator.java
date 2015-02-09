package com.shop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by wchuchla on 2015-02-09.
 */
public class StreetConstraintValidator implements ConstraintValidator<Street, String> {
    @Override
    public void initialize(Street street) {

    }

    @Override
    public boolean isValid(String streetField, ConstraintValidatorContext constraintValidatorContext) {
        if(streetField == null || streetField.isEmpty()) {
            return true;
        }
        return streetField.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
    }
}
