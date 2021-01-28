package com.pramod.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class BonusNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2559369980096076930L;

	public BonusNotFoundException(String message) {
		super(message);
	}
}
