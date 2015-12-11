package com.ekart.account.security;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LoginAttemptService {

    private final int MAX_ATTEMPT = 10;

    AtomicInteger failedAttempts = new AtomicInteger(0);

    public LoginAttemptService() {
        super();

    }

    public void loginSucceeded(final String key) {
        failedAttempts = new AtomicInteger(0);
    }

    public void loginFailed(final String key) {
        failedAttempts.incrementAndGet();
    }

    public boolean isBlocked(final String key) {
        return failedAttempts.get() >= MAX_ATTEMPT;

    }
}
