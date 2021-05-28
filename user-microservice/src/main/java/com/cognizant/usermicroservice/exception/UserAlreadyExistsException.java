package com.cognizant.usermicroservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Already Exits")
public class UserAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserAlreadyExistsException.class);

	public UserAlreadyExistsException() {
		logger.debug("inside UserAlreadyExistsException class");
	}

}
