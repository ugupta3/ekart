package com.ekart.security;

import com.ekart.account.entity.Privilege;
import com.ekart.account.entity.Role;
import com.ekart.account.entity.User;
import com.ekart.account.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Inject
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);
        String lowercaseLogin = login.toLowerCase();
        Optional<User> userFromDatabase = Optional.ofNullable(userRepository.findByEmail(lowercaseLogin));
        return userFromDatabase.map(user -> {
            if (!user.isActive()) {
                throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
            }
            List<GrantedAuthority> grantedAuthorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole().getName()));
            return new org.springframework.security.core.userdetails.User(lowercaseLogin,
                    user.getPassword(),
                    grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the " +
                "database"));
    }


}
