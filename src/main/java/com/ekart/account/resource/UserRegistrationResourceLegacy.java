/*
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

*/
/**
 * Created by umam on 12/6/15.
 *//*

@Path("/user")
public class UserRegistrationResourceLegacy {


    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private MessageSource messages;

    @POST
    @Path(value = "/register")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse registerUserAccount(@BeanParam final UserRegistrationRequest accountDto,
                                               @Context HttpServletRequest request) {

        LOGGER.debug("Registering user account with information: {}", accountDto);
        return userService.registerNewUserAccount(accountDto);

    }

    @GET
    @Path(value = "/regitrationConfirm")
    @Consumes(MediaType.APPLICATION_JSON)
    */
/*url with token appended with  token
    * if succes go to home page
    *  else got to login page or else we can implement using OTO later*//*

    public GenericResponse confirmRegistration(@Qualifier("token") final String token) {

        final VerificationToken verificationToken = userService.getVerificationToken(token);

        if (verificationToken == null) {

        }
        final User user = verificationToken.getUser();
        //final Calendar cal = Calendar.getInstance();
       */
/* if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            model.addAttribute("message", messages.getMessage("auth.message.expired", null, locale));
            model.addAttribute("expired", true);
            model.addAttribute("token", token);
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }
        *//*

        user.setEnabled(true);
        userService.saveRegisteredUser(user);
        // model.addAttribute("message", messages.getMessage("message.accountVerified", null, locale));
        return new GenericResponse("Registartion Confirme");
    }

    // user activation - verification


    @GET
    @Path(value = "/resendRegistrationToken")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse resendRegistrationToken(@Context HttpServletRequest request,
                                                   @QueryParam("token") final String existingToken) {
        final VerificationToken newToken = userService.generateNewVerificationToken(existingToken);
        final User user = userService.getUser(newToken.getToken());
        final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        final SimpleMailMessage email = constructResendVerificationTokenEmail(appUrl, request.getLocale(), newToken, user);
        //mailSender.send(email);

        return new GenericResponse(messages.getMessage("message.resendToken", null, request.getLocale()));
    }

    @GET
    @Path(value = "/resetPassword")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse resetPassword(@Context HttpServletRequest request,
                                         @QueryParam("email") final String userEmail) {
        final User user = userService.findUserByEmail(userEmail);
        if (user == null) {
            throw new UserNotFoundException();
        }

        final String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);
        final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        final SimpleMailMessage email = constructResetTokenEmail(appUrl, request.getLocale(), token, user);
        //mailSender.send(email);
        return new GenericResponse(messages.getMessage("message.resetPasswordEmail", null, request.getLocale()));
    }
*/
/*
    @RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
    public String showChangePasswordPage(@RequestParam("id") final long id,
                                         @RequestParam("token") final String token) {
        final PasswordResetToken passToken = userService.getPasswordResetToken(token);
        final User user = passToken.getUser();
        if (passToken == null || user.getId() != id) {
            final String message = messages.getMessage("auth.message.invalidToken", null, null);
            //model.addAttribute("message", message);
            return "redirect:/login.html?lang=";
        }

        final Calendar cal = Calendar.getInstance();
        if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            model.addAttribute("message", messages.getMessage("auth.message.expired", null, locale));
            return "redirect:/login.html?lang=" + locale.getLanguage();
        }

        final Authentication auth = new UsernamePasswordAuthenticationToken(user, null, userDetailsService.loadUserByUsername(user.getEmail()).getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        return "redirect:/updatePassword.html?lang=" + locale.getLanguage();
    }
*//*


    @POST
    @Path(value = "savePassword")
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasRole('READ_PRIVILEGE')")
    public GenericResponse savePassword(final Locale locale, @QueryParam("password") final String password) {
        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.changeUserPassword(user, password);
        return new GenericResponse(messages.getMessage("message.resetPasswordSuc", null, locale));
    }

    @POST
    @Path(value = "updatePassword")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse changeUserPassword(final Locale locale,
                                              @QueryParam("password") final String password,
                                              @QueryParam("oldpassword") final String oldPassword) {

        final User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (!userService.checkIfValidOldPassword(user, oldPassword)) {
            throw new InvalidOldPasswordException();
        }
        userService.changeUserPassword(user, password);
        return new GenericResponse(messages.getMessage("message.updatePasswordSuc", null, locale));
    }

    // NON-API

    private final SimpleMailMessage constructResendVerificationTokenEmail(final String contextPath, final Locale locale, final VerificationToken newToken, final User user) {
        final String confirmationUrl = contextPath + "/regitrationConfirm.html?token=" + newToken.getToken();
        final String message = messages.getMessage("message.resendToken", null, locale);
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject("Resend Registration Token");
        email.setText(message + " \r\n" + confirmationUrl);
        email.setTo(user.getEmail());
        //  email.setFrom(env.getProperty("support.email"));
        return email;
    }

    private final SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale, final String token, final User user) {
        final String url = contextPath + "/user/changePassword?id=" + user.getId() + "&token=" + token;
        final String message = messages.getMessage("message.resetPassword", null, locale);
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Reset Password");
        email.setText(message + " \r\n" + url);
        //email.setFrom(env.getProperty("support.email"));
        return email;
    }


}
*/
