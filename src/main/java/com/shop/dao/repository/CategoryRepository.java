package com.shop.dao.repository;

import com.shop.dao.CategoryDao;
import com.shop.exceptions.DaoException;
import com.shop.models.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-06.
 */
@Repository
public class CategoryRepository implements CategoryDao {
    private static final String SELECT_CATEGORIES     = "from Category c";
    private static final String SELECT_CATEGORY_BY_ID = "from Category c where c.id = :id";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> getCategories(int offset, int limit) {
        List result = sessionFactory
                .openSession()
                .createQuery(SELECT_CATEGORIES)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .list();

        return (List<Category>) result;
    }

    @Override
    public Category getCategory(int id) {
        List result = sessionFactory
                .openSession()
                .createQuery(SELECT_CATEGORY_BY_ID)
                .list();

        if (result.size() > 0) {
            return (Category) result.get(0);
        }
        return null;
    }

    @Override
    public void remove(Category category) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction tx  = session.beginTransaction();

        try {
            session.delete(category);
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new DaoException(ex.getMessage(), ex);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Category category) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction tx  = session.beginTransaction();

        try {
            session.update(category);
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new DaoException(ex.getMessage(), ex);
        } finally {
            session.close();
        }
    }

    @Override
    public void add(Category category) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction tx  = session.beginTransaction();

        try {
            session.save(category);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new DaoException(ex.getMessage(), ex);
        }
    }
}
