package com.cognizant.usermicroservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Mentor Alread have these skills")
public class MentorSkillAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(MentorSkillAlreadyExistsException.class);

	public MentorSkillAlreadyExistsException() {
		logger.debug("inside MentorSkillAlreadyExistsException class");
	}
}
