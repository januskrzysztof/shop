package com.shop.exceptions;

import com.shop.models.User;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
public class UserNotEnabledException extends AuthenticationException {
    private User user;

    public UserNotEnabledException(User user) {
        this(String.format("User: '%s' is not enabled.", user.getUsername()));
    }

    public UserNotEnabledException(String msg) {
        super(msg);
    }
}
