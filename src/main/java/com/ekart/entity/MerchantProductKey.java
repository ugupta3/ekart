package com.ekart.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the et_pricing database table.
 */
@Embeddable
public class MerchantProductKey implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "product_id", unique = true, nullable = false)
    private Long productId;

    @Column(name = "merchant_id", unique = true, nullable = false)
    private Long merchantId;

    public MerchantProductKey() {
    }
    public MerchantProductKey(Long productId, Long merchantId) {
        this.productId = productId;
        this.merchantId = merchantId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MerchantProductKey)) {
            return false;
        }
        MerchantProductKey castOther = (MerchantProductKey) other;
        return
                this.productId.equals(castOther.productId)
                        && this.merchantId.equals(castOther.merchantId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.productId.hashCode();
        hash = hash * prime + this.merchantId.hashCode();

        return hash;
    }
}