package com.ekart.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the et_pricing database table.
 */
@Embeddable
public class MerchantProductKey implements Serializable {
   // default serial version id, required for serializable classes.
   private static final long serialVersionUID = 1L;

   @Column(name = "product_id", unique = true, nullable = false)
   private long productId;

   @Column(name = "merchant_id", unique = true, nullable = false)
   private long merchantId;

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

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      MerchantProductKey that = (MerchantProductKey) o;

      if (productId != that.productId)
         return false;
      return merchantId == that.merchantId;

   }

   @Override
   public int hashCode() {
      int result = (int) (productId ^ (productId >>> 32));
      result = 31 * result + (int) (merchantId ^ (merchantId >>> 32));
      return result;
   }
}