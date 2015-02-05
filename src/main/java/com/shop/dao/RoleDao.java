package com.shop.dao;

import com.shop.models.Role;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
public interface RoleDao {
    public Role getRole(int id);
    public Role getRoleByName(String name);
}
