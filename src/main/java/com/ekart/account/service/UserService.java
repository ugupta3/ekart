package com.ekart.account.service;


import com.ekart.account.entity.PasswordResetToken;
import com.ekart.account.entity.User;
import com.ekart.account.entity.VerificationToken;
import com.ekart.account.request.UserRegistrationRequest;
import com.ekart.account.response.GenericResponse;


public interface UserService {

    GenericResponse registerNewUserAccount(UserRegistrationRequest accountDto);

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    void createVerificationTokenForUser(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(User user, String token);

    User findUserByEmail(String email);

    PasswordResetToken getPasswordResetToken(String token);

    User getUserByPasswordResetToken(String token);

    User getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);
    User findUserByPhone(long phone);

}
