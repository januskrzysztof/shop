package com.shop.repository;

import com.shop.models.Category;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Krzysztof Januś on 2015-02-02.
 */
@Repository("categoryRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Category category) {
        entityManager.persist(category);
    }

    public Category getCategoryByName(String name) {
        Query query = entityManager.createQuery("select c from Category c where c.name = ?1")
                .setParameter(1, name);

        return (Category) query.getSingleResult();
    }
}
