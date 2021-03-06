package com.ekart.entity;

import com.ekart.account.entity.User;

import javax.persistence.*;


/**
 * The persistent class for the et_pricing database table.
 */
@Entity
@Table(name = "ek_pricing")
@NamedQueries(
        {
            @NamedQuery(name = "Pricing.findAll", query = "SELECT p FROM Pricing p")
        }
)
public class Pricing {

    @EmbeddedId
    private MerchantProductKey id;

    @Column(name = "ek_percentage")
    private double ekPercentage;

    @Column(name = "sell_price")
    private double sellPrice;

    @Column(name = "merchant_price")
    private double merchantPrice;
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="merchant_id", insertable = false, updatable = false)
    private User user;



    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "merchant_id", referencedColumnName= "merchant_id"),
            @JoinColumn(name = "product_id", referencedColumnName= "product_id")
    })
    private Inventory inventory;


    public Pricing() {

    }

    public MerchantProductKey getId() {
        return this.id;
    }

    public void setId(MerchantProductKey id) {
        this.id = id;
    }

    public double getEkPercentagek() {
        return this.ekPercentage;
    }

    public void setEkPercentage(double ekPercentage) {
        this.ekPercentage = ekPercentage;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}