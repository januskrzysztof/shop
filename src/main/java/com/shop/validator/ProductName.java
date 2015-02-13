package com.shop.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductNameConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductName {

	String message() default "Invalid product name";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}