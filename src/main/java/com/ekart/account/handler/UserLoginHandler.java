package com.ekart.account.handler;

import com.ekart.account.entity.User;
import com.ekart.account.repositories.UserRepository;
import com.ekart.account.service.UserService;
import com.ekart.security.xauth.Token;
import com.ekart.security.xauth.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;

/**
 * Created by uma on 11-12-2015.
 */
@Named
public class UserLoginHandler {
    @Inject
    private UserDetailsService userDetailsService;

    @Inject
    private AuthenticationManager authenticationManager;

    @Inject
    private TokenProvider tokenProvider;


    @Inject
    private UserRepository userRepository;


    public Token createTokenUsingEmailAndPassword(String email, String password) {

        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(email, password);
            Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
            return tokenProvider.createToken(userDetails);
        } catch (Exception e) {
            return new Token(null,0);
        }

    }

    public Token createTokenUsingPhoneAndPassword(long phone, String password) {

        String email = userRepository.findByPhone(phone).getEmail();
        return createTokenUsingEmailAndPassword(email, password);
    }
}
