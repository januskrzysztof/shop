package com.shop.dao.repository;

import com.shop.dao.UserDao;
import com.shop.exceptions.DaoException;
import com.shop.models.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Krzysztof Januś on 2015-02-04.
 */
@Repository("userRepository")
public class UserRepository implements UserDao {
    @Autowired
    private SessionFactory em;

    @Override
    public User findUserByUsername(String username) {
        Session session = em.openSession();
        return (User) session.createQuery("from User u where u.username = :username").setParameter("username", username).list().get(0);
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void update(User user) throws DaoException {
        Session session = em.openSession();
        Transaction tx  = session.beginTransaction();

        try {
            session.update(user);
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        }
    }

    @Override
    public void remove(User user) throws DaoException {
        Session session = em.openSession();
        Transaction tx  = session.beginTransaction();

        try {
            session.delete(user);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        }
    }

    @Override
    public void add(User user) throws DaoException {
        Session session = em.openSession();
        Transaction tx  = session.beginTransaction();

        try {
            session.save(user);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        }
    }
}
