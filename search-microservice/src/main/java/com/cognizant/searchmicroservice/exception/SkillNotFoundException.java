package com.cognizant.searchmicroservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "These skills are yet to be Added to portal")
public class SkillNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(SkillNotFoundException.class);

	public SkillNotFoundException() {
		logger.debug("inside SkillNotFoundException class");
	}
}
