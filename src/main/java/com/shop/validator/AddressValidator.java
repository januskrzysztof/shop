package com.shop.validator;

import com.shop.models.Address;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Wojtek on 2015-02-09.
 */
public class AddressValidator implements Validator{
	@Override
	public boolean supports(Class<?> aClass) {
		return Address.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Address address = (Address) o;
	}
}
