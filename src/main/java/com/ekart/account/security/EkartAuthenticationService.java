package com.ekart.account.security;

import com.ekart.account.security.rest.AuthenticationService;
import com.ekart.account.security.rest.TokenInfo;
import com.ekart.account.security.rest.TokenManager;
import com.ekart.cache.CacheManagerCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 * Service responsible for all around authentication, token checks, etc.
 * This class does not care about HTTP protocol at all.
 */
@Named
public class EkartAuthenticationService implements AuthenticationService {


	private static final Logger logger = LoggerFactory
			.getLogger(EkartAuthenticationService.class);

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private  AuthenticationManager authenticationManager;
	@Autowired
	private  TokenManager tokenManager;

	public EkartAuthenticationService() {
	}

	public EkartAuthenticationService(AuthenticationManager authenticationManager, TokenManager tokenManager) {
		this.authenticationManager = authenticationManager;
		this.tokenManager = tokenManager;
	}


	@Override
	public TokenInfo authenticate(String login, String password) {
		logger.info(" *** EkartAuthenticationService.authenticate");

		// Here principal=username, credentials=password
		Authentication authentication = new UsernamePasswordAuthenticationToken(login, password);
		try {
			authentication = authenticationManager.authenticate(authentication);
			// Here principal=UserDetails (UserContext in our case), credentials=null (security reasons)
			SecurityContextHolder.getContext().setAuthentication(authentication);
			logger.info("Authenication from AuthService" + authentication);

			if (authentication.getPrincipal() != null) {
				UserDetails userContext = (UserDetails) authentication.getPrincipal();
				TokenInfo newToken = tokenManager.createNewToken(userContext);
				if (newToken == null) {
					return null;
				}
				return newToken;
			}
		} catch (AuthenticationException e) {
			logger.info(" *** EkartAuthenticationService.authenticate - FAILED: " + e.toString());
		}
		return null;
	}

	@Override
	public boolean checkToken(String token) {
		logger.info(" *** EkartAuthenticationService.checkToken");

		UserDetails userDetails = tokenManager.getUserDetails(token);
		if (userDetails == null) {
			return false;
		}

		UsernamePasswordAuthenticationToken securityToken = new UsernamePasswordAuthenticationToken(
			userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(securityToken);

		return true;
	}

	@Override
	public void logout(String token) {
		UserDetails logoutUser = tokenManager.removeToken(token);
		logger.info(" *** EkartAuthenticationService.logout: " + logoutUser);
		SecurityContextHolder.clearContext();
	}

	@Override
	public UserDetails currentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		return null;
	}
}
