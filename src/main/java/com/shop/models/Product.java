package com.shop.models;

import com.shop.validator.Price;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Krzysztof Januś on 2015-02-02.
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(nullable = false, length = 255)
    @NotEmpty(message = "Category name cannot be empty")
    private String name;

    @Column(name = "net_price", nullable = false, columnDefinition = "DECIMAL(11,4) default '0.000'", precision = 11, scale = 4)
    @Price
    private double netPrice;

    @Column
    private String description;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "modified_at", nullable = false)
    private Date modifiedAt;

    @Valid
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "category_id", referencedColumnName = "id")
    private Category category;

    public Product() {
        createdAt  = new Date();
        modifiedAt = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", netPrice=" + netPrice +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", category=" + category +
                '}';
    }
}
