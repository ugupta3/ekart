package com.ekart.account.resource;

import com.ekart.account.entity.User;
import com.ekart.account.entity.VerificationToken;
import com.ekart.account.request.UserRegistrationRequest;
import com.ekart.account.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Locale;
import java.util.UUID;


@Path("/user")
public class UserRegistrationResource {


    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;


    @POST
    @Path(value = "/register")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> registerUserAccount
            (@BeanParam final UserRegistrationRequest userRegistrationRequest,
             @Context HttpServletRequest request) {

        LOGGER.debug("Registering user account with information: {}", userRegistrationRequest);
        return userService.registerNewUserAccount(userRegistrationRequest);

    }

    @POST
    @Path(value = "/changePassword")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> changeUserPassword
            (@FormParam("password") final String password,
             @FormParam("oldpassword") final String oldPassword) {

        final User user = userService.findUserByEmail(SecurityContextHolder.getContext().
                getAuthentication().getName());
        if (!userService.checkIfValidOldPassword(user, oldPassword)) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body("Update password Succefull");
        }
        userService.changeUserPassword(user, password);
        return ResponseEntity.ok("Update password Succefull");
    }
}
