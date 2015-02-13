package com.shop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductNameConstraintValidator implements ConstraintValidator<ProductName, String> {
	@Override
	public void initialize(ProductName constraintAnnotation) {

	}

	@Override
	public boolean isValid(String productNameField, ConstraintValidatorContext context) {
		return !productNameField.isEmpty();
	}
}
