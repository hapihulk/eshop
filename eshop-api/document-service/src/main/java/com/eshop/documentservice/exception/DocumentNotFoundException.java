package com.eshop.documentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DocumentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DocumentNotFoundException(String message) {
		super(message);
	}

	public DocumentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
