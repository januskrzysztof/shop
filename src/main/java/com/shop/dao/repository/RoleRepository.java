package com.shop.dao.repository;

import com.shop.dao.RoleDao;
import com.shop.models.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class RoleRepository implements RoleDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Role getRole(int id) {
        try {
            return (Role) em.createQuery("from Role r where r.id = ?1")
                            .setParameter(1, id)
                            .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Role getRoleByName(String name) {
        try {
            return (Role) em.createQuery("from Role r where r.name = ?1")
                            .setParameter(1, name)
                            .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
