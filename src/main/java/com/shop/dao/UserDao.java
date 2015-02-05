package com.shop.dao;

import com.shop.exceptions.DaoException;
import com.shop.models.User;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
public interface UserDao {
    public User findUserByUsername(String username);
    public User getUser(int id);
    public void update(User user) throws DaoException;
    public void remove(User user) throws DaoException;
    public void add(User user) throws DaoException;
}
