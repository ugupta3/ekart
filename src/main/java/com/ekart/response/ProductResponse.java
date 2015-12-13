package com.ekart.response;


import com.fasterxml.jackson.annotation.JsonProperty;



public class ProductResponse {
    @JsonProperty
    private Long productId;
    @JsonProperty
    private String imageUrl;
    @JsonProperty
    private String productName;
    @JsonProperty
    private String itemLocation;
    @JsonProperty
    private double price;
    @JsonProperty
    private Long merchantId;


    public ProductResponse(Long productId, String imageUrl, String productName, String itemLocation,double price, Long merchantId) {
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.itemLocation = itemLocation;
        this.price=price;
        this.merchantId = merchantId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public double getPrice() {
        return price;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
}
