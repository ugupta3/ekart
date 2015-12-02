package com.ekart.constants;

/**
 * Created by umam on 11/26/15.
 */
public enum OrderStatus {
    PENDING("1"),
    SUCCESS("2"),
    FAILED("3");


    OrderStatus(String str) {
        orderStatusStngValue = str;
    }

    public String stringValue() {
        return orderStatusStngValue;
    }

    private String orderStatusStngValue;


}
