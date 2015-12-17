package com.ekart.security.xauth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The security token.
 */

public class Token {
    @JsonProperty
    String token;
    @JsonProperty
    long expires;


    public Token(String token, long expires) {
        this.token = token;
        this.expires = expires;
    }

    public String getToken() {
        return token;
    }

    public long getExpires() {
        return expires;
    }
}
