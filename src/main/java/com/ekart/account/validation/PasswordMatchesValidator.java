package com.ekart.account.validation;

import com.ekart.account.request.UserRegistrationRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final UserRegistrationRequest user = (UserRegistrationRequest) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}
