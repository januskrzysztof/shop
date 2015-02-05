package com.shop.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by apbudzinski on 2015-02-05.
 */
@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue
    @Column
    int id;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "client_has_products",
            joinColumns        = {@JoinColumn(name = "client_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "product_id", nullable = false, updatable = false)})
    private List<Product> products;

    public int getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
