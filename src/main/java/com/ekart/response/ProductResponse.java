package com.ekart.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class ProductResponse {
   @JsonProperty
   private long productId;
   @JsonProperty
   private String imageUrl;
   @JsonProperty
   private String productName;
   @JsonProperty
   private String itemLocation;
   @JsonProperty
   private double price;
   @JsonProperty
   private long merchantId;

   public ProductResponse(long productId, String imageUrl, String productName, String itemLocation, double price,
                     long merchantId) {
      this.productId = productId;
      this.imageUrl = imageUrl;
      this.productName = productName;
      this.itemLocation = itemLocation;
      this.price = price;
      this.merchantId = merchantId;
   }

   public long getProductId() {
      return productId;
   }

   public void setProductId(long productId) {
      this.productId = productId;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public String getItemLocation() {
      return itemLocation;
   }

   public void setItemLocation(String itemLocation) {
      this.itemLocation = itemLocation;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public long getMerchantId() {
      return merchantId;
   }

   public void setMerchantId(long merchantId) {
      this.merchantId = merchantId;
   }
}
