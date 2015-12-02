package com.ekart.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the et_order_payment_transaction database table.
 * 
 */
@Entity
@Table(name="et_order_payment_transaction")
@NamedQuery(name="OrderPaymentTransaction.findAll", query="SELECT o FROM OrderPaymentTransaction o")
public class OrderPaymentTransaction  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="payment_transaction_id", unique=true, nullable=false)
	private String paymentTransactionId;

	private byte archived;

	@Column(name="customer_ip_address", length=255)
	private String customerIpAddress;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_recorded")
	private Date dateRecorded;

	@Lob
	@Column(name="raw_response")
	private String rawResponse;

	private byte success;

	@Column(name="transaction_amount", precision=10, scale=2)
	private BigDecimal transactionAmount;

	@Column(name="transaction_type", length=255)
	private String transactionType;



	public OrderPaymentTransaction() {
	}

	public String getPaymentTransactionId() {
		return this.paymentTransactionId;
	}

	public void setPaymentTransactionId(String paymentTransactionId) {
		this.paymentTransactionId = paymentTransactionId;
	}

	public byte getArchived() {
		return this.archived;
	}

	public void setArchived(byte archived) {
		this.archived = archived;
	}

	public String getCustomerIpAddress() {
		return this.customerIpAddress;
	}

	public void setCustomerIpAddress(String customerIpAddress) {
		this.customerIpAddress = customerIpAddress;
	}

	public Date getDateRecorded() {
		return this.dateRecorded;
	}

	public void setDateRecorded(Date dateRecorded) {
		this.dateRecorded = dateRecorded;
	}

	public String getRawResponse() {
		return this.rawResponse;
	}

	public void setRawResponse(String rawResponse) {
		this.rawResponse = rawResponse;
	}

	public byte getSuccess() {
		return this.success;
	}

	public void setSuccess(byte success) {
		this.success = success;
	}

	public BigDecimal getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}



}