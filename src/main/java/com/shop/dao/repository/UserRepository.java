package com.shop.dao.repository;

import com.shop.dao.UserDao;
import com.shop.exceptions.DaoException;
import com.shop.models.Person;
import com.shop.models.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-04.
 */
@Repository("userRepository")
public class UserRepository implements UserDao {


    @Autowired
    private SessionFactory em;


    @Override
    public List<User> getUsers() {
        return (List<User>) em
                .openSession()
                .createQuery("from User u order by u.username")
                .list();
    }

    @Override
    public List<User> findUserByLastName(String lastName) {
        Session session = em.openSession();
        List<Person> persons;
        List<User> users = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        persons = (List<Person>) session.createQuery("from Person p where p.lastName = :lastName")
                .setParameter("lastName", lastName).list();

        try {
            for (int i = 0; i < persons.size(); i++) {
                User user = (User) session.createQuery("from User u where u.person= :id")
                        .setParameter("id", persons.get(i)).list().get(i);
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findUserByUsername(String username) {
        Session session = em.openSession();
        try {
            return (User) session.createQuery("from User u where u.username = :username").setParameter("username", username).list().get(0);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public User getUser(int id) {
        return (User) em.openSession()
                .createQuery("from User u where u.id = :id")
                .setParameter("id",id).list()
                .get(0);
    }

    @Override
    public void update(User user) throws DaoException {
        Session session = em.openSession();
        Transaction tx = session.beginTransaction();

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
        Transaction tx = session.beginTransaction();

        try {
            session.delete(user);
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        }
    }

    @Override
    public void add(User user) throws DaoException {
        Session session = em.openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.save(user);
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        }
    }
}
