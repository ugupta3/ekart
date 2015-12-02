package com.ekart.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class ProductResponse {
    @JsonProperty
    private BigInteger productId;
    @JsonProperty
    private String imageUrl;
    @JsonProperty
    private String productName;
    @JsonProperty
    private String itemLocation;
    @JsonProperty
    private double price;


    public ProductResponse(BigInteger productId, String imageUrl, String productName, String itemLocation,double price) {
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.itemLocation = itemLocation;
        this.price=price;
    }

    public BigInteger getProductId() {
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
}
