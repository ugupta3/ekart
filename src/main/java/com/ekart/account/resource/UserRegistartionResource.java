package com.ekart.account.resource;

import com.ekart.account.entity.User;
import com.ekart.account.entity.VerificationToken;
import com.ekart.account.error.InvalidOldPasswordException;
import com.ekart.account.error.UserNotFoundException;
import com.ekart.account.request.UserRegistrationRequest;
import com.ekart.account.service.UserService;
import com.ekart.account.response.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
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

/**
 * Created by umam on 12/6/15.
 */
@Path("/user")
public class UserRegistartionResource {


    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;


    @POST
    @Path(value = "/register")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse registerUserAccount
            (@BeanParam final UserRegistrationRequest accountDto,
             @Context HttpServletRequest request) {

        LOGGER.debug("Registering user account with information: {}", accountDto);
        return userService.registerNewUserAccount(accountDto);

    }

    @POST
    @Path(value = "/changePassword")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse changeUserPassword
            (@QueryParam("password") final String password,
             @QueryParam("oldpassword") final String oldPassword) {

        final User user = userService.findUserByEmail(SecurityContextHolder.getContext().
                getAuthentication().getName());
        if (!userService.checkIfValidOldPassword(user, oldPassword)) {
            throw new InvalidOldPasswordException();
        }
        userService.changeUserPassword(user, password);
        return new GenericResponse("Update password Succefull");
    }
}
