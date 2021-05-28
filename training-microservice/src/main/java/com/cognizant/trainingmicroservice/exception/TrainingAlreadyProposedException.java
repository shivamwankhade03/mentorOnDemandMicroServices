package com.cognizant.trainingmicroservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Training Already Proposed")
public class TrainingAlreadyProposedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrainingAlreadyProposedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainingAlreadyProposedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TrainingAlreadyProposedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TrainingAlreadyProposedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TrainingAlreadyProposedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
