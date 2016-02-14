package com.ekart.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * The persistent class for the et_order database table.
 */
@Entity
@Table(name = "ek_order")

@NamedQueries({ @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o"),
      @NamedQuery(name = "Order.getOrderByCustomerIdAndStatus", query = " SELECT o FROM Order o"
                        + " where o.customerId = ?1 AND o.orderStatus=?2") })
public class Order {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "order_id", unique = true, nullable = false)
   private long orderId;

   @Column(name = "customer_id")
   private long customerId;

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
   private double orderSubtotal;

   @Column(name = "order_total", precision = 10, scale = 5)
   private double orderTotal;

   @Column(name = "session_id")
   private long sessionId;

   @Column(name = "shipping_cost", precision = 10, scale = 5)
   private double shippingCost;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
   List<OrderItem> orderItems;

   public Order() {
      this.orderItems = new ArrayList<OrderItem>();
   }

   public Long getOrderId() {
      return orderId;
   }

   public void setOrderId(Long orderId) {
      this.orderId = orderId;
   }

   public Long getCustomerId() {
      return this.customerId;
   }

   public void setCustomerId(Long customerId) {
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

   public void setOrderId(long orderId) {
      this.orderId = orderId;
   }

   public void setSessionId(long sessionId) {
      this.sessionId = sessionId;
   }

   public double getOrderTotal() {
      return orderTotal;
   }

   public void setOrderTotal(double orderTotal) {
      this.orderTotal = orderTotal;
   }

   public double getOrderSubtotal() {
      return orderSubtotal;
   }

   public void setOrderSubtotal(double orderSubtotal) {
      this.orderSubtotal = orderSubtotal;
   }

   public void setCustomerId(long customerId) {
      this.customerId = customerId;
   }

   public Long getSessionId() {
      return this.sessionId;
   }

   public void setSessionId(Long sessionId) {
      this.sessionId = sessionId;
   }

   public double getShippingCost() {
      return shippingCost;
   }

   public void setShippingCost(double shippingCost) {
      this.shippingCost = shippingCost;
   }

   public List<OrderItem> getOrderItems() {
      return orderItems;
   }

   public void setOrderItems(List<OrderItem> orderItems) {
      this.orderItems = orderItems;
   }

}