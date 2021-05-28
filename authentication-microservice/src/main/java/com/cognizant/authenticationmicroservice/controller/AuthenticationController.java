package com.cognizant.authenticationmicroservice.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	public AuthenticationController() {
	}

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		Map<String, String> temp = new HashMap<String, String>();
		String user = getUser(authHeader);
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		String t = generateJwt(user);
		temp.put("token", t);
		temp.put("role", role);
		logger.debug("token " + t);
		logger.debug("role " + role);
		System.err.println(temp.toString());
		return temp;
	}

	private String getUser(String authHeader) {
		String encodedCredentials = authHeader.substring(6);
		encodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
		encodedCredentials = encodedCredentials.substring(0, encodedCredentials.indexOf(":"));
		return encodedCredentials;

	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		// Set the token issue time as current time
		builder.setIssuedAt(new Date());

		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();

		return token;
	}

}
