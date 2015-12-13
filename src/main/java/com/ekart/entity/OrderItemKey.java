package com.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by santhosh on 10/12/2015.
 * This is primary key for OrderItem class
 * Consists (orderId, merchantId, productId)
 */
@Embeddable
public class OrderItemKey implements Serializable {
    @Column(name = "order_id", unique = true, nullable = false)
    private Long orderId;

    @Column(name="merchant_id",unique = true, nullable=false)
    private Long merchantId;

    @Column(name = "product_id", unique = true, nullable = false)
    private Long productId;


    public OrderItemKey(){

    }
    public OrderItemKey(Long orderId,Long merchantId, Long productId){
        this.orderId = orderId;
        this.merchantId = merchantId;
        this.productId = productId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        OrderItemKey guest = (OrderItemKey) obj;
        return this.orderId==guest.getOrderId() && this.merchantId==guest.getMerchantId() && this.productId == guest.getProductId();
    }
}
