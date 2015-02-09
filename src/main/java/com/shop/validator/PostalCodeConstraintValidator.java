package com.shop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by wchuchla on 2015-02-09.
 */
public class PostalCodeConstraintValidator implements ConstraintValidator<PostalCode, String> {
    @Override
    public void initialize(PostalCode postalCode) {

    }

    @Override
    public boolean isValid(String postalCodeField, ConstraintValidatorContext constraintValidatorContext) {
        if(postalCodeField == null) {
            return false;
        }
        return postalCodeField.matches("^[0-9]{5}(-[0-9]{4})?$");
    }
}
