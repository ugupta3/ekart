package com.ekart.entity;

import javax.persistence.*;


/**
 * The persistent class for the et_pricing database table.
 */
@Entity
@Table(name = "et_pricing")
@NamedQuery(name = "Pricing.findAll", query = "SELECT p FROM Pricing p")
public class Pricing {

    @EmbeddedId
    private PricingPK id;

    @Column(name = "et_percentage")
    private double etPercentage;

    @Column(name = "sell_price")
    private double sellPrice;

    @Column(name = "merchant_price")
    private double merchantPrice;
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="merchant_id", insertable = false, updatable = false)
    private UserAccount userAccount;


    public Pricing() {

    }

    public PricingPK getId() {
        return this.id;
    }

    public void setId(PricingPK id) {
        this.id = id;
    }

    public double getEtPercentage() {
        return this.etPercentage;
    }

    public void setEtPercentage(double etPercentage) {
        this.etPercentage = etPercentage;
    }

    public double getSellPrice() {
        return this.sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getMerchantPrice() {
        return merchantPrice;
    }

    public void setMerchantPrice(double merchantPrice) {
        this.merchantPrice = merchantPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}