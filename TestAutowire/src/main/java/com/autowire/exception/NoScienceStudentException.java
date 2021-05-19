package com.autowire.exception;

public class NoScienceStudentException extends RuntimeException{
	private String errorMessage;

	public NoScienceStudentException(String msg) {
		super(msg);
		this.errorMessage = msg;
	}

	public NoScienceStudentException() {
		super();
	}
}
