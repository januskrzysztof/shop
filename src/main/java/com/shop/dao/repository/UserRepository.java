package com.shop.dao.repository;

import com.shop.dao.UserDao;
import com.shop.exceptions.DaoException;
import com.shop.models.User;
import com.shop.services.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Krzysztof Januś on 2015-02-04.
 */
@Repository("userRepository")
public class UserRepository extends AbstractRepository implements UserDao {
    @Override
    public User findUserByUsername(String username) {
        try {
            return (User) em().createQuery("from User u where u.username = ?1")
                    .setParameter(1, username)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public User getUser(int id) {
        try {
            return (User) em().createQuery("from User u where u.id = ?1")
                            .setParameter(1, id)
                            .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void update(User user) throws DaoException {
        TransactionStatus transaction = begin();
        try {
            em().merge(user);
            em().flush();
            commit(transaction);
        } catch (Exception ex) {
            rollBack(transaction);
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(User user) throws DaoException {
//        TransactionStatus transaction = begin();
        try {
            em().merge(user);
            em().remove(user);
            em().flush();
//            commit(transaction);
        } catch (Exception ex) {
//            rollBack(transaction);
            throw new DaoException(ex.getMessage(), ex);
        }
    }

    @Override
    public void add(User user) throws DaoException {
        TransactionStatus transaction = begin();

        try {
            em().persist(user);
            em().flush();
            commit(transaction);
        } catch (Throwable ex) {
            rollBack(transaction);
            throw new DaoException(ex.getMessage(), ex);
        }
    }
}
