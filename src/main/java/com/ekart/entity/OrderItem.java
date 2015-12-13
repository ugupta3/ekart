package com.ekart.entity;

import javax.persistence.*;


/**
 * The persistent class for the et_order_item database table.
 * 
 */
@Entity
@Table(name="ek_order_item")
@NamedQueries({
		@NamedQuery(name = "OrderItem.findAll", query = "SELECT o FROM OrderItem o"),
		@NamedQuery(name = "OrderItem.findByOrderId", query = "SELECT o FROM OrderItem o" +
				" WHERE order_id = ?1"
		)
}
)

public class OrderItem  {

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_item_id", unique=true, nullable=false)
	private Long orderItemId;*/

	@EmbeddedId
	private OrderItemKey id;

    @ManyToOne
	@JoinColumn(name = "order_id",insertable =false ,updatable = false)
	private Order order;

	@Column(name="ek_percentage")
	private double ekPercentage;


/*
	@Column(name="order_id", nullable=false)
	private Long orderId;

	@Column(name="product_id", nullable=false)
	private Long productId;
*/
	private int quantity;

	@Column(name="sell_price")
	private double sellPrice;

	@Column(name="total_price")
	private double totalPrice;

	@Column(name="vendor_price")
	private double merchantPrice;

	public OrderItem() {
	}

	public OrderItemKey getId() {
		return id;
	}

	public void setId(OrderItemKey id) {
		this.id = id;
	}

	public double getMerchantPrice() {
		return merchantPrice;
	}

	public void setMerchantPrice(double merchantPrice) {
		this.merchantPrice = merchantPrice;
	}

	public double getEkPercentage() {
		return this.ekPercentage;
	}

	public void setEkPercentage(double ekPercentage) {
		this.ekPercentage = ekPercentage;
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
	@Override
	public boolean equals(Object obj){
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		OrderItem guest = (OrderItem) obj;
		return this.getId().equals(((OrderItem) obj).getId());
	}
}