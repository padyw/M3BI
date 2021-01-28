package com.pramod.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class PendingApprovalNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 281646314669342366L;

	public PendingApprovalNotFoundException(String message) {
		super(message);
	}
}
