package com.shop.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

    String message() default "Invalid phone number (required +001-123-456-789 format)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}