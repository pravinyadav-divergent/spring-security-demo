package com.divergentsl.springbootsecurity;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;

@Controller
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());
		if ("pravin".equals(username) && "77738".equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
		} else {
			throw new AuthenticationCredentialsNotFoundException("Error!");
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
	}

}
