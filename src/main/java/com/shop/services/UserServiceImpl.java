package com.shop.services;

import com.shop.dao.RoleDao;
import com.shop.dao.UserDao;
import com.shop.exceptions.DaoException;
import com.shop.models.Role;
import com.shop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Krzysztof Januś on 2015-02-09.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public void registerUser(User user) throws DaoException {
        if (passwordEncoder != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        Role role = roleDao.getRoleByName("ROLE_MEMBER");
        if (role == null) {
            throw new DaoException("Role cannot be null");
        }

        user.setRole(role);
        user.setEnabled(true);
        userDao.add(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
