package com.shop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by wchuchla on 2015-02-09.
 */
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext constraintValidatorContext) {
        if(phoneField == null) {
            return false;
        }
        return phoneField.matches("^([\\+]*)([0-9]{2,3})\\-?[-]?([0-9]{3})\\-?[-]?([0-9]{3})[-]\\-?([0-9]{3})$");
    }
}
