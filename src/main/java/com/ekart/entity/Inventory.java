package com.ekart.entity;

import javax.persistence.*;


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
    private long inventoryId;

    @Column(name = "quantity_in_hand", nullable = false)
    private long quantityInHand;

    @OneToOne(mappedBy="inventory")
    private Pricing pricing;

    public Inventory() {
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getQuantityInHand() {
        return this.quantityInHand;
    }

    public void setQuantityInHand(Long quantityInHand) {
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