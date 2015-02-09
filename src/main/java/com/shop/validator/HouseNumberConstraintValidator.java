package com.shop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by wchuchla on 2015-02-09.
 */
public class HouseNumberConstraintValidator implements ConstraintValidator<HouseNumber, String> {
    @Override
    public void initialize(HouseNumber houseNumber) {

    }

    @Override
    public boolean isValid(String houseNumberField, ConstraintValidatorContext constraintValidatorContext) {
        if(houseNumberField == null) {
            return false;
        }

        return houseNumberField.matches("^\\d+[a-zA-Z]*$");
    }
}
