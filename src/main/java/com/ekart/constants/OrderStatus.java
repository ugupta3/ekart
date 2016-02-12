package com.ekart.constants;

/**
 * Created by umam on 11/26/15.
 */
public enum OrderStatus {
    OPEN("1"),
    PENDING("2"),
    SUCCESS("3"),
    FAILED("4");


    OrderStatus(String str) {
        orderStatusStrngValue = str;
    }

    public String stringValue() {
        return orderStatusStrngValue;
    }

    private String orderStatusStrngValue;


}
