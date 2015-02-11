package com.shop.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-02.
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @Valid
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "parent", referencedColumnName = "id", nullable = true)
    private Category parent;

    @OneToMany(targetEntity = Category.class, mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> children = new ArrayList<>();

    public Category() {
        this("");
    }

    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChild(Category category) {
        category.setParent(this);
        children.add(category);
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Category getParent() {
        return parent;
    }
}
