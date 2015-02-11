package com.shop.services;

import com.shop.exceptions.DaoException;
import com.shop.models.User;

/**
 * Created by Krzysztof Januś on 2015-02-09.
 */
public interface UserService {
    public void registerUser(User user) throws DaoException;
    public User findUserByUsername(String username);
    public User getUser(int id);
    public void update(User user) throws DaoException;
}
