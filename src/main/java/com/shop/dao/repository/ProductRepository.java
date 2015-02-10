package com.shop.dao.repository;

import com.shop.dao.ProductDao;
import com.shop.exceptions.DaoException;
import com.shop.models.Category;
import com.shop.models.Product;
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
public class ProductRepository implements ProductDao {


    private static final String SELECT_PRODUCTS = "from Product p";
    private static final String SELECT_PRODUCT = "from Product p where p.id = :id";
    private static final String SELECT_PRODUCTS_BY_NAME = "from Product p where p.name like :name ";
   // private static final String SELECT_PRODUCTS_BY_CATEGORY = "from Product p join p.category as c where c.name = :name";
    private static final String GET_CATEGORY_ID = "from Category c where c.name = :name";
    private static final String SELECT_PRODUCTS_BY_CATEGORY_ID = "from Product p where p.category = :c";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getProducts(int offset, int limit) {
        return (List<Product>) sessionFactory
                .openSession()
                .createQuery(SELECT_PRODUCTS)
                .setFirstResult(0)
                .setMaxResults(limit)
                .list();
    }

    @Override
    public List<Product> findProductsByName(String name) {
       if(!name.isEmpty()) {
           return (List<Product>) sessionFactory
                   .openSession()
                   .createQuery(SELECT_PRODUCTS_BY_NAME)
                   .setParameter("name", "%" + name + "%")
                   .list();
       }
        return null;
    }

    @Override
    public List<Product> findProductsByCategory(String categoryName) {
     List<Category> categories =(List<Category>)sessionFactory.openSession()
                .createQuery(GET_CATEGORY_ID).setParameter("name",categoryName).list();
        Category c = null;
       if(categories.size()>0) {
          c = categories.get(0);
       }
        return (List<Product>)  sessionFactory
                .openSession()
                .createQuery(SELECT_PRODUCTS_BY_CATEGORY_ID)
                .setParameter("c", c)
                .list();
    }

    @Override
    public Product getProduct(int id) {
        List result = sessionFactory
                .openSession()
                .createQuery(SELECT_PRODUCT)
                .setParameter("id", id)
                .list();

        if (result.size() > 0) {
            return (Product) result.get(0);
        }
        return null;
    }

    @Override
    public void remove(Product product) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.delete(product);
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
    public void update(Product product) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.saveOrUpdate(product);
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
    public void add(Product product) throws DaoException {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.save(product);
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new DaoException(ex.getMessage(), ex);
        } finally {
            session.close();
        }
    }
}
