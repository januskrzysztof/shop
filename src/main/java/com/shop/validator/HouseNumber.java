package com.shop.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HouseNumberConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface HouseNumber {


    String message() default "Invalid house number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}