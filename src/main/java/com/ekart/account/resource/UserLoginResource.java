package com.ekart.account.resource;

import com.ekart.account.handler.UserLoginHandler;
import com.ekart.security.xauth.Token;
import com.ekart.security.xauth.TokenProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by uma on 11-12-2015.
 */
@Path("/user")
public class UserLoginResource {

    private UserLoginHandler loginHandler;

    @Inject
    public UserLoginResource(UserLoginHandler loginHandler) {
        this.loginHandler = loginHandler;
    }

    @POST
    @Path(value = "/loginWithEmail")
    @Produces({MediaType.APPLICATION_JSON})
    public Token loginUsingEmail(@FormParam("email") String email,
                                 @FormParam("password") String password) {

        return loginHandler.createTokenUsingEmailAndPassword(email, password);
    }

    @POST
    @Path(value = "/loginWithPhone")
    @Produces({MediaType.APPLICATION_JSON})
    public Token loginUsingPhone(@FormParam("phone") long phone,
                                 @FormParam("password") String password) {

        return loginHandler.createTokenUsingPhoneAndPassword(phone, password);
    }

}

