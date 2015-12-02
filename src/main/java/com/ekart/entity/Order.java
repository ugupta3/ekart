package com.ekart.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the et_order database table.
 */
@Entity
@Table(name = "et_order")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", unique = true, nullable = false)
    private BigInteger orderId;

    @Column(name = "customer_id")
    private BigInteger customerId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "date_updated")
    private Date dateUpdated;

    @Column(name = "order_name", length = 255)
    private String orderName;

    @Column(name = "order_status", length = 255)
    private String orderStatus;

    @Column(name = "order_subtotal", precision = 10, scale = 5)
    private BigDecimal orderSubtotal;

    @Column(name = "order_total", precision = 10, scale = 5)
    private BigDecimal orderTotal;

    @Column(name = "session_id")
    private BigInteger sessionId;

    @Column(name = "shipping_cost", precision = 10, scale = 5)
    private BigDecimal shippingCost;

    public Order() {
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }


    public BigInteger getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return this.dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getOrderName() {
        return this.orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderSubtotal() {
        return this.orderSubtotal;
    }

    public void setOrderSubtotal(BigDecimal orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    public BigDecimal getOrderTotal() {
        return this.orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public BigInteger getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(BigInteger sessionId) {
        this.sessionId = sessionId;
    }

    public BigDecimal getShippingCost() {
        return this.shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

}