package com.ekart.entity;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the et_order_payment database table.
 * 
 */
@Entity
@Table(name="et_order_payment")
@NamedQuery(name="OrderPayment.findAll", query="SELECT o FROM OrderPayment o")
public class OrderPayment  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_payment_id", unique=true, nullable=false)
	private long orderPaymentId;

	@Column(name="address_id")
	private long addressId;

	@Column(precision=10, scale=5)
	private BigDecimal amount;

	private Boolean archived;

	@Column(name="gateway_type", length=255)
	private String gatewayType;

	@Column(name="order_id")
	private long orderId;

	@Column(name="payment_type", nullable=false, length=255)
	private String paymentType;

	@Column(name="reference_number", length=255)
	private String referenceNumber;


	public OrderPayment() {
	}


	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public String getGatewayType() {
		return this.gatewayType;
	}

	public void setGatewayType(String gatewayType) {
		this.gatewayType = gatewayType;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getReferenceNumber() {
		return this.referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}




}