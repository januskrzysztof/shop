package com.shop.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PostalCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PostalCode {

    String message() default "Invalid postal code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}