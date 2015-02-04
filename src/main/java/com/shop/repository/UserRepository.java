package com.shop.repository;

import com.shop.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Krzysztof Januś on 2015-02-04.
 */
@Repository("userRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public User findUserByUsername(String username) {
        try {
            return (User) entityManager.createQuery("from User u where u.username = ?1")
                    .setParameter(1, username)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
