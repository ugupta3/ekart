package com.ekart.account.request;

import com.ekart.account.validation.PasswordMatches;
import com.ekart.account.validation.ValidEmail;
import com.ekart.account.validation.ValidPassword;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

@PasswordMatches
public class UserRegistrationRequest {
    @NotNull
    @Size(min = 1)
    @FormParam("firstName")
    private String firstName;

    @NotNull
    @Size(min = 1)
    @FormParam("lastName")
    private String lastName;

    @ValidPassword
    @FormParam("password")
    private String password;

    @NotNull
    @Size(min = 1)
    @FormParam("matchingPassword")
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1)
    @FormParam("email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    private Integer role;

    public Integer getRole() {
        return role;
    }

    public void setRole(final Integer role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(final String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [firstName=").append(firstName).append("]").append("[lastName=").append(lastName).append("]").append("[email").append(email).append("]").append("[password").append(password).append("]");
        return builder.toString();
    }
}
