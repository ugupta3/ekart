package com.ekart.constants;

/**
 * Created by umam on 11/28/15.
 */
public enum CategoryType {
    water("water");

    CategoryType(String str) {
        catergoryTypeString = str;
    }

    public String stringValue() {
        return catergoryTypeString;
    }

    private String catergoryTypeString;

}
