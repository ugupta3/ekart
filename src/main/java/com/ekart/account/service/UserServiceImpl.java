package com.ekart.account.service;

import com.ekart.account.entity.PasswordResetToken;
import com.ekart.account.entity.User;
import com.ekart.account.entity.VerificationToken;
import com.ekart.account.repositories.PasswordResetTokenRepository;
import com.ekart.account.repositories.RoleRepository;
import com.ekart.account.repositories.UserRepository;
import com.ekart.account.repositories.VerificationTokenRepository;
import com.ekart.account.request.UserRegistrationRequest;
import com.ekart.security.AuthoritiesConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ResponseEntity<String> registerNewUserAccount(final UserRegistrationRequest userRegistrationRequest) {

        if (emailExist(userRegistrationRequest.getEmail())) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                    "There is an account with that email adress: " +
                            userRegistrationRequest.getEmail());
        } else {
            final User user = new User();
            user.setFirstName(userRegistrationRequest.getFirstName());
            user.setLastName(userRegistrationRequest.getLastName());
            user.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
            user.setEmail(userRegistrationRequest.getEmail());
            user.setRole_id(roleRepository.findByName(AuthoritiesConstants.USER).getId());
            user.setIsActive(true);
            userRepository.save(user);
            return ResponseEntity.ok(
                    "Confirmation Email has sent please check your mail Inbox and confirm ");

        }
    }


    @Override
    public User getUser(final String verificationToken) {
        final User user = verificationTokenRepository.findByToken(verificationToken).getUser();
        return user;
    }

    @Override
    public User findUserByPhone(long phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public VerificationToken getVerificationToken(final String VerificationToken) {
        return verificationTokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void saveRegisteredUser(final User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(final User user) {
        userRepository.delete(user);
    }

    @Override
    public void createVerificationTokenForUser(final User user, final String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        verificationTokenRepository.save(myToken);
    }

    @Override
    public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
        VerificationToken vToken = verificationTokenRepository.findByToken(existingVerificationToken);
        vToken.updateToken(UUID.randomUUID().toString());
        vToken = verificationTokenRepository.save(vToken);
        return vToken;
    }

    @Override
    public void createPasswordResetTokenForUser(final User user, final String token) {
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(myToken);
    }

    @Override
    public User findUserByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public PasswordResetToken getPasswordResetToken(final String token) {
        return passwordTokenRepository.findByToken(token);
    }

    @Override
    public User getUserByPasswordResetToken(final String token) {
        return passwordTokenRepository.findByToken(token).getUser();
    }

    @Override
    public User getUserByID(final long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void changeUserPassword(final User user, final String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(final User user, final String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    private boolean emailExist(final String email) {
        final User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

}