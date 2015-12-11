package com.ekart.account.handler;

import com.ekart.account.entity.User;
import com.ekart.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Named;
import javax.ws.rs.core.Response;

/**
 * Created by uma on 11-12-2015.
 */
@Named
public class UserLoginHandler {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean checkUserCredentialByEmail(String email, String password) {
        User user = userService.findUserByEmail(email);
        return passwordEncoder.matches(password,user.getPassword());

    }

    public Boolean checkUserCredentialByPhone(long phone, String password) {
        User user = userService.findUserByPhone(phone);
        return passwordEncoder.matches(password,user.getPassword());
    }
}
