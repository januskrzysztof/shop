package com.shop.dao.repository;

import com.shop.dao.RoleDao;
import com.shop.models.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-06.
 */
@Repository
public class RoleRepository implements RoleDao {
    private static final String SELECT_ROLE_BY_ID   = "from Role r where r.id = :id";
    private static final String SELECT_ROLE_BY_NAME = "from Role r where r.name = :name";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRole(int id) {
        List result = sessionFactory.openSession().createQuery(SELECT_ROLE_BY_ID).setParameter("id", id).list();
        if (result.size() > 0) {
            return (Role) result.get(0);
        }
        return null;
    }

    @Override
    public Role getRoleByName(String name) {
        List result = sessionFactory.openSession().createQuery(SELECT_ROLE_BY_NAME).setParameter("name", name).list();
        if (result.size() > 0) {
            return (Role) result.get(0);
        }
        return null;
    }
}
