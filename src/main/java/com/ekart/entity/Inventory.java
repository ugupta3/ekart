package com.ekart.entity;

import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the et_inventory database table.
 */
@Entity
@Table(name = "et_inventory")
@NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_id", unique = true, nullable = false)
    private BigInteger inventoryId;

    @Column(name = "merchant_id")
    private BigInteger merchantId;

    @Column(name = "product_id")
    private BigInteger productId;

    @Column(name = "quantity_in_hand", nullable = false)
    private BigInteger quantityInHand;

    public Inventory() {
    }

    public BigInteger getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(BigInteger inventoryId) {
        this.inventoryId = inventoryId;
    }

    public BigInteger getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(BigInteger merchantId) {
        this.merchantId = merchantId;
    }

    public BigInteger getProductId() {
        return this.productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public BigInteger getQuantityInHand() {
        return this.quantityInHand;
    }

    public void setQuantityInHand(BigInteger quantityInHand) {
        this.quantityInHand = quantityInHand;
    }

}