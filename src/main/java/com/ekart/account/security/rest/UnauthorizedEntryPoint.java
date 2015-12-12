package com.ekart.account.security.rest;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * {@link AuthenticationEntryPoint} that rejects all requests. Login-like function is featured
 * in {@link TokenAuthenticationFilter} and this does not perform or suggests any redirection.
 * This object is hit whenever user is not authorized (anonymous) and secured resource is requested.
 */
public final class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		System.out.println(" *** UnauthorizedEntryPoint.commence: " + request.getRequestURI());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	}
}