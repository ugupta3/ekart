package com.ekart.account.validation;

import com.ekart.account.request.UserRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final UserRequest user = (UserRequest) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}
