package com.cognizant.searchmicroservice.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.cognizant.searchmicroservice.dto.UserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		logger.info("Start");
		logger.debug("{}: ", authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Start");
		String header = req.getHeader("Authorization");
		logger.debug(header);
		if (header == null || !header.startsWith("Bearer ")) {
			chain.doFilter(req, res);
			return;
		}
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
		logger.info("End");
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token != null) {
			// parse the token.
			Jws<Claims> jws;
			try {
				jws = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token.replace("Bearer ", ""));
				String user = jws.getBody().getSubject();

				String role = user.substring(user.length() - 1, user.length());
				String us_name = user.substring(0, user.length() - 1);

				UserDto users = new UserDto(us_name, null, role);
				AppUser appUser = new AppUser(users);

				logger.debug(user);
				if (user != null) {
					return new UsernamePasswordAuthenticationToken(appUser, null, appUser.getAuthorities());
				}
			} catch (JwtException ex) {
				return null;
			}
		}
		return null;
	}
}
