package com.shop.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Krzysztof Januś on 2015-02-02.
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "net_price", nullable = false, columnDefinition = "DECIMAL(11,4) default '0.000'", precision = 11, scale = 4)
    private double netPrice;

    @Column
    private String description;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "modified_at", nullable = false)
    private Date modifiedAt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "products_has_categoires",
            joinColumns        = {@JoinColumn(name = "product_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "category_id", nullable = false, updatable = false)})
    private List<Category> categories;

    public Product() {
        createdAt  = new Date();
        modifiedAt = new Date();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }
}
