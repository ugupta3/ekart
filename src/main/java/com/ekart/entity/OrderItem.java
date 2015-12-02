package com.ekart.entity;

import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the et_order_item database table.
 * 
 */
@Entity
@Table(name="et_order_item")
@NamedQuery(name="OrderItem.findAll", query="SELECT o FROM OrderItem o")
public class OrderItem  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_item_id", unique=true, nullable=false)
	private BigInteger orderItemId;

	@Column(name="et_percentage")
	private double etPercentage;

	@Column(name="merchant_id", nullable=false)
	private BigInteger merchantId;

	@Column(name="order_id", nullable=false)
	private BigInteger orderId;

	@Column(name="product_id", nullable=false)
	private BigInteger productId;

	private int quantity;

	@Column(name="sell_price")
	private double sellPrice;

	@Column(name="total_price")
	private double totalPrice;

	@Column(name="vendor_price")
	private double merchantPrice;

	public OrderItem() {
	}

	public BigInteger getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(BigInteger orderItemId) {
		this.orderItemId = orderItemId;
	}

	public double getMerchantPrice() {
		return merchantPrice;
	}

	public void setMerchantPrice(double merchantPrice) {
		this.merchantPrice = merchantPrice;
	}

	public double getEtPercentage() {
		return this.etPercentage;
	}

	public void setEtPercentage(double etPercentage) {
		this.etPercentage = etPercentage;
	}

	public BigInteger getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(BigInteger merchantId) {
		this.merchantId = merchantId;
	}

	public BigInteger getOrderId() {
		return this.orderId;
	}

	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	public BigInteger getProductId() {
		return this.productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


}