package com.ekart.entity;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.*;


/**
 * The persistent class for the et_product database table.
 */
@Entity
@Table(name = "et_product")
@NamedQueries(
        {@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
                @NamedQuery(name = "Product.getProductsByCategory", query = "SELECT p FROM Product p" +
                        " JOIN FETCH p.category  c " +
                        " JOIN FETCH p.pricing  prc " +
                        " where c.categoryName = ?1 ")
        }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", unique = true, nullable = false)
    private BigInteger productId;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "category_id")
    private BigInteger categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id",insertable =false ,updatable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Pricing> pricing;


    public Product() {
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Pricing> getPricing() {
        return pricing;
    }

    public void setPricing(List<Pricing> pricing) {
        this.pricing = pricing;
    }
}
