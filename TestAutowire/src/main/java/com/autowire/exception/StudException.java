package com.autowire.exception;

public class StudException extends RuntimeException {
	private String errorMessage;

	public StudException(String msg) {
		super(msg);
		this.errorMessage = msg;
	}

	public StudException() {
		super();
	}

}
