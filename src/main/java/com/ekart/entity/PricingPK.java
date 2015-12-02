package com.ekart.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;

/**
 * The primary key class for the et_pricing database table.
 */
@Embeddable
public class PricingPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "product_id", unique = true, nullable = false)
    private BigInteger productId;

    @Column(name = "merchant_id", unique = true, nullable = false)
    private BigInteger merchantId;

    public PricingPK() {
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public BigInteger getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(BigInteger merchantId) {
        this.merchantId = merchantId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PricingPK)) {
            return false;
        }
        PricingPK castOther = (PricingPK) other;
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