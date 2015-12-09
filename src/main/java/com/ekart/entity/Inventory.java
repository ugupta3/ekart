package com.ekart.entity;

import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the et_inventory database table.
 */
@Entity
@Table(name = "ek_inventory")
@NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
public class Inventory {

    @EmbeddedId
    private MerchantProductKey id;

    @Column(name = "inventory_id")
    private BigInteger inventoryId;

    @Column(name = "quantity_in_hand", nullable = false)
    private BigInteger quantityInHand;

    @OneToOne(mappedBy="inventory")
    private Pricing pricing;

    public Inventory() {
    }

    public BigInteger getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(BigInteger inventoryId) {
        this.inventoryId = inventoryId;
    }

    public BigInteger getQuantityInHand() {
        return this.quantityInHand;
    }

    public void setQuantityInHand(BigInteger quantityInHand) {
        this.quantityInHand = quantityInHand;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public MerchantProductKey getId() {
        return id;
    }

    public void setId(MerchantProductKey id) {
        this.id = id;
    }
}