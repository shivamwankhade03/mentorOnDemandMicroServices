package com.cognizant.trainingmicroservice;

public class ResponseTransfer {
	private String message;

	public ResponseTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseTransfer(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseTransfer [message=" + message + "]";
	}

}
