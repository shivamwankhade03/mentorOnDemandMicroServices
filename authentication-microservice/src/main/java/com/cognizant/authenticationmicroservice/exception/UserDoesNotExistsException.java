package com.cognizant.authenticationmicroservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Already Exits")
public class UserDoesNotExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserDoesNotExistsException.class);

	public UserDoesNotExistsException() {
		logger.debug("inside UserDoesNotExistsException class");
	}

}
