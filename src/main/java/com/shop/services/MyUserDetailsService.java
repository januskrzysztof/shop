package com.shop.services;

import com.shop.dao.UserDao;
import com.shop.exceptions.UserNotEnabledException;
import com.shop.models.Role;
import com.shop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-04.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        if (!user.isEnabled()) {
            throw new UserNotEnabledException(user);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        Role role = user.getRole();

        do {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        } while ((role = role.getParent()) != null);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                authorities
        );
    }
}
