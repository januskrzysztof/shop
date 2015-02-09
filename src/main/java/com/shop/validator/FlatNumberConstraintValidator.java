package com.shop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by wchuchla on 2015-02-09.
 */
public class FlatNumberConstraintValidator implements ConstraintValidator<FlatNumber, String> {
    @Override
    public void initialize(FlatNumber flatNumber) {

    }

    @Override
    public boolean isValid(String flatNumberField, ConstraintValidatorContext constraintValidatorContext) {
        if(flatNumberField == null || flatNumberField.isEmpty()) {
            return true;
        }
        return flatNumberField.matches("^\\d+[a-zA-Z]*$");
    }
}
