package com.shop.validator;

import com.shop.models.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Wojtek on 2015-02-09.
 */
public class PersonValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return Person.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Person person = (Person) o;
	}
}
