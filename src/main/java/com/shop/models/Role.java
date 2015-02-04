package com.shop.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-04.
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "parent", referencedColumnName = "id")
    private Role parent;

    @OneToMany(mappedBy = "parent")
    private List<Role> children = new ArrayList<>();

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getParent() {
        return parent;
    }

    public void setParent(Role parent) {
        this.parent = parent;
    }
}
