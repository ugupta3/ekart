package com.ekart.account.resource;

import com.ekart.account.handler.UserLoginHandler;
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
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by uma on 11-12-2015.
 */
@Path("/user")
public class UserLoginResource {

    @Inject
    private UserDetailsService userDetailsService;

    @Inject
    private AuthenticationManager authenticationManager;

    private UserLoginHandler loginHandler;
    private PasswordEncoder passwordEncoder;

    @Inject
    public UserLoginResource(UserLoginHandler loginHandler, PasswordEncoder passwordEncoder) {
        this.loginHandler = loginHandler;
        this.passwordEncoder = passwordEncoder;
    }

    @POST
    @Path(value = "/loginWithEmail")
    public Response loginUsingEmail(@FormParam("email") String email,
                                    @FormParam("password") String password) {


        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);

        return loginHandler.checkUserCredentialByEmail(email, password) ?
                Response.ok("logged In ").build() :
                Response.serverError().type("Invalid login details").build();

    }

    @POST
    @Path(value = "/loginWithPhone")
    public Response loginUsingPhone(@FormParam("email") String email,
                                    @FormParam("phone") long phone,
                                    @FormParam("password") String password) {


        return loginHandler.checkUserCredentialByPhone(phone, password) ?
                Response.ok("logged In ").build() :
                Response.serverError().type("Invalid login details").build();


    }
}
