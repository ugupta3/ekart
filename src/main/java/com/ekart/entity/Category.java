package com.ekart.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the et_category database table.
 */
@Entity
@Table(name = "ek_category")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", unique = true, nullable = false)
    private BigInteger categoryId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "active_end_date")
    private Date activeEndDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "active_start_date")
    private Date activeStartDate;

    @Column(name = "category_name", nullable = false, length = 255)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> products;


    public Category() {
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public Date getActiveEndDate() {
        return activeEndDate;
    }

    public void setActiveEndDate(Date activeEndDate) {
        this.activeEndDate = activeEndDate;
    }

    public Date getActiveStartDate() {
        return activeStartDate;
    }

    public void setActiveStartDate(Date activeStartDate) {
        this.activeStartDate = activeStartDate;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}