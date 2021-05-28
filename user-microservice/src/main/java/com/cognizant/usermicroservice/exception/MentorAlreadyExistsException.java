package com.cognizant.usermicroservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Mentor Already Exits")
public class MentorAlreadyExistsException extends Exception {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(MentorAlreadyExistsException.class);

	public MentorAlreadyExistsException() {
		logger.debug("inside MentorAlreadyExistsException class");
	}
}
